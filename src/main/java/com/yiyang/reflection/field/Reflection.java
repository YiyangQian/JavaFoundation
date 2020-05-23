package com.yiyang.reflection.field;


import java.lang.reflect.Field;

/**
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；
 *
 */
public class Reflection {
    public static void main(String[] args) throws Exception{
        Class studentClass = Class.forName("com.yiyang.reflection.field.Student");

        System.out.println("--- all public fields ---");
        Field[] fields = studentClass.getFields();
        for (Field field: fields) {
            System.out.println(field);
        }

        System.out.println("--- all fields ---");
        Field[] declaredFields = studentClass.getDeclaredFields();
        for(Field field: declaredFields) {
            System.out.println(field);
        }

        System.out.println("--- get public field and modify value ---");
        Field nameField = studentClass.getField("name");
        System.out.println(nameField);
        Object o = studentClass.getConstructor().newInstance();
        nameField.set(o, "Goldbach");
        Student student = (Student) o;
        System.out.println(student.name);

        System.out.println("--- get private field and modify ---");
        Field phoneNumField = studentClass.getDeclaredField("phoneNum");
        System.out.println(phoneNumField);
        phoneNumField.setAccessible(true);
        phoneNumField.set(o, "001-0000-1111");
        System.out.println("verify phone number");
        System.out.println(student);
    }
}
