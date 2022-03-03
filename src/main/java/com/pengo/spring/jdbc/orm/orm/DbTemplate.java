package com.pengo.spring.jdbc.orm.orm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.*;

/**TODO
 * @author pengo
 * @description:
 * @date 2022/3/2 13:36
 */
@Slf4j
public class DbTemplate {
    final JdbcTemplate jdbcTemplate;
    private Map<Class<?>, Mapper<?>> classMapping;

    public DbTemplate(JdbcTemplate jdbcTemplate, String basePackage) {
        this.jdbcTemplate = jdbcTemplate;
        List<Class<?>> classes = scanEntities(basePackage);
        Map<Class<?>, Mapper<?>> classMapping = new HashMap<>();
        try {
            for (Class<?> clazz : classes) {
                log.info("Found class: " + clazz.getName());
                Mapper<?> mapper = new Mapper<>(clazz);
                classMapping.put(clazz, mapper);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.classMapping = classMapping;
    }

    public <T> T get(Class<T> clazz, Object id) {
        T t = fetch(clazz, id);
        if (t == null) {
            throw new EntityNotFoundException(clazz.getSimpleName());
        }
        return t;
    }

    public <T> T fetch(Class<T> clazz, Object id) {
        Mapper<T> mapper = getMapper(clazz);
        log.info("SQL: " + mapper.selectSQL);
        List<T> list = jdbcTemplate.query(mapper.selectSQL, new Object[]{id}, mapper.rowMapper);
        if (list.isEmpty())
            return null;
        return list.get(0);
    }

    public <T> void delete(T bean) {
        try {
            Mapper<?> mapper = getMapper(bean.getClass());
            delete(bean.getClass(), mapper.getIdValue(bean));
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public <T> void delete(Class<T> clazz, Object id) {
        Mapper<?> mapper = getMapper(clazz);
        log.info("SQL: " + mapper.deleteSQL);
        jdbcTemplate.update(mapper.deleteSQL, id);
    }

    @SuppressWarnings("unchecked")
    <T> Mapper<T> getMapper(Class<T> clazz) {
        Mapper<T> mapper = (Mapper<T>) this.classMapping.get(clazz);
        if (mapper == null) {
            throw new RuntimeException("Target class is not a registered entity: " + clazz.getName());
        }
        return mapper;
    }

    private static List<Class<?>> scanEntities(String basePackage) {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
        List<Class<?>> classes = new ArrayList<>();
        Set<BeanDefinition> beans = provider.findCandidateComponents(basePackage);
        for (BeanDefinition bean : beans) {
            try {
                classes.add(Class.forName(bean.getBeanClassName()));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return classes;
    }
}
