package com.yiyang.reflection.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 *
 * 1.获取构造方法：
 * 		1).批量的方法：
 * 			public Constructor[] getConstructors()：所有"公有的"构造方法
 *          public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
 *
 * 		2).获取单个的方法，并调用：
 * 			public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
 * 			public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *
 * 			调用构造方法：
 * 			Constructor-->newInstance(Object... initargs)
 */
public class Reflection {
    public static void main(String[] args) throws Exception {
        Class studentClass = Class.forName("com.yiyang.reflection.constructor.Student");

        //get all public constructors
        System.out.println("---- get public constructors ---");
        Constructor[] constructors = studentClass.getConstructors();
        for (Constructor constructor: constructors) {
            System.out.println(constructor);
        }

        //get all constructors
        System.out.println("---- get all constructors ---");
        constructors = studentClass.getDeclaredConstructors();
        for (Constructor constructor: constructors) {
            System.out.println(constructor);
        }

        //get public constructor with no input
        System.out.println("---- get public constructor with no param ---");
        Constructor constructor = studentClass.getConstructor(null);
        System.out.println("constructor: " + constructor);
        Object o = constructor.newInstance();
        Student student = (Student) o;

        //get private constructor
        System.out.println("---- get private constructor ---");
        constructor = studentClass.getDeclaredConstructor(int.class);
        System.out.println("constructor: " + constructor);
        //ignore private restriction
        constructor.setAccessible(true);
        o = constructor.newInstance(10);
    }
}
