package com.pengo.spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2022/3/2 10:37
 */
public abstract class AbstractDao<T> extends JdbcDaoSupport {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @PostConstruct
    public void setJdbcTemplate() {
        super.setJdbcTemplate(jdbcTemplate);
    }

    private String table;
    private Class<T> entityClass;
    private RowMapper<T> rowMapper;

    public AbstractDao() {
        this.entityClass = getParameterizedType();
        this.table = this.entityClass.getSimpleName().toLowerCase() + "s";
        this.rowMapper = new BeanPropertyRowMapper<>(entityClass);
    }

    public T getById(Long id) {
        return getJdbcTemplate().queryForObject("select * from " + table + " where id = ?", rowMapper, id);
    }

    public List<T> getAll(int page) {
        int limit = 100;
        int offset = limit * (page - 1);
        return getJdbcTemplate().query("select * from " + table + " limit ? offset ?", new Object[]{limit, offset}, this.rowMapper);
    }

    public void deleteById(Long id) {
        getJdbcTemplate().update("delete from " + table + " where id =?", id);
    }

    @SuppressWarnings("unchecked")
    private Class<T> getParameterizedType() {
        Type type = getClass().getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Class " + getClass().getName() + " does not have parameterized type.");
        }
        ParameterizedType pt = (ParameterizedType) type;
        Type[] types = pt.getActualTypeArguments();
        if (types.length != 1) {
            throw new IllegalArgumentException(
                    "Class " + getClass().getName() + " has more than 1 parameterized types.");
        }
        Type r = types[0];
        if (!(r instanceof Class<?>)) {
            throw new IllegalArgumentException(
                    "Class " + getClass().getName() + " does not have parameterized type of class.");
        }
        return (Class<T>) r;
    }
}
