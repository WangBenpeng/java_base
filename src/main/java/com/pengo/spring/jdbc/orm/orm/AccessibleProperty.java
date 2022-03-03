package com.pengo.spring.jdbc.orm.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**TODO
 * @author pengo
 * @description:
 * @date 2022/3/2 13:48
 */
public class AccessibleProperty {
    final Method getter;
    final Method setter;

    final Class<?> propertyType;
    final String propertyName;
    final String columnName;

    public AccessibleProperty(PropertyDescriptor pd) {
        this.getter = pd.getReadMethod();
        this.setter = pd.getWriteMethod();
        this.propertyType = pd.getReadMethod().getReturnType();
        this.propertyName = pd.getName();
        this.columnName = getColumnName(pd.getReadMethod(), propertyName);
    }

    boolean isId() {
        return this.getter.isAnnotationPresent(Id.class);
    }

    boolean isIdentityId() {
        if (!isId()) {
            return false;
        }
        GeneratedValue gv = this.getter.getAnnotation(GeneratedValue.class);
        if (gv == null) {
            return false;
        }
        GenerationType strategy = gv.strategy();
        return strategy == GenerationType.IDENTITY;
    }

    boolean isInsertable() {
        if (isIdentityId())
            return false;
        Column col = this.getter.getAnnotation(Column.class);
        return col == null || col.insertable();
    }

    boolean isUpdatable() {
        if (isId()) return false;
        Column cl = this.getter.getAnnotation(Column.class);
        return cl == null || cl.updatable();
    }

    private static String getColumnName(Method m, String defaultName) {
        Column col = m.getAnnotation(Column.class);
        if (col == null || col.name().isEmpty())
            return defaultName;
        return col.name();
    }














}
