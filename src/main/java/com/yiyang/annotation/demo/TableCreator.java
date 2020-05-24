package com.yiyang.annotation.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * output:
 * generated SQL for creating table com.yiyang.annotation.demo.Member:
 * CREATE TABLE MEMBER (
 * ID VARCHAR(50) NOT NULL PRIMARY KEY,
 * NAME VARCHAR(30) NOT NULL,
 * AGE INT NOT NULL,
 * DESCRIPTION VARCHAR(150),
 * );
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        String[] classNames = new String[]{"com.yiyang.annotation.demo.Member"};
        for(String className: classNames) {
            System.out.println("generated SQL for creating table " + className
                    + ": \n" + createSQL(className));
        }
    }

    private static String createSQL(String className) throws ClassNotFoundException {
        Class<?> c = Class.forName(className);
        DBTable dbTable = c.getAnnotation(DBTable.class);
        String tableName = getTableName(className, dbTable);

        List<String> fieldSQLs = createFieldSQL(c);

        StringBuilder sb = new StringBuilder("CREATE TABLE " + tableName + " (");
        for (String fieldSQL: fieldSQLs) {
            sb.append("\n");
            sb.append(fieldSQL);
            sb.append(",");
        }
        sb.append("\n");
        sb.append(");");
        return sb.toString();
    }

    private static List<String> createFieldSQL(Class<?> c) {
        List<String> columnDefs = new ArrayList<>();
        for (Field field: c.getDeclaredFields()) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length < 1) continue;
            for (Annotation annotation: annotations) {
                if (annotation instanceof SQLString) {
                    getSQLForStringField(columnDefs, field, (SQLString) annotation);
                    break;
                }
                if (annotation instanceof SQLInteger) {
                    getSQLForIntegerField(columnDefs, field, (SQLInteger) annotation);
                    break;
                }
            }
        }
        return columnDefs;
    }

    private static String getTableName(String className, DBTable dbTable) {
        if(dbTable == null) {
            System.out.println("No DBTable annotation in class " + className);
            return null;
        }
        String tableName = dbTable.name();
        if (tableName.length() < 1)
            tableName = className.toUpperCase();
        return tableName;
    }

    private static void getSQLForStringField(List<String> columnDefs, Field field, SQLString sqlString) {
        String columnName = sqlString.name().length() < 1 ? field.getName().toUpperCase() : sqlString.name();
        columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")" + getConstraints(sqlString.constraint()));
    }

    private static void getSQLForIntegerField(List<String> columnDefs, Field field, SQLInteger sqlInteger) {
        String columnName = sqlInteger.name().length() < 1 ? field.getName().toUpperCase() : sqlInteger.name();
        columnDefs.add(columnName + " INT" + getConstraints(sqlInteger.constraint()));
    }

    private static String getConstraints(Constraints constraint) {
        StringBuilder sb = new StringBuilder();
        if (!constraint.allowNull())
            sb.append(" NOT NULL");
        if (constraint.primaryKey())
            sb.append(" PRIMARY KEY");
        if (constraint.unique())
            sb.append(" UNIQUE");
        return sb.toString();
    }
}
