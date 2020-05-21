package com.yiyang.reflection.constructor;

import java.sql.Struct;

public class Student {
    Student(String str) {
        System.out.println("default constructor " + str);
    }

    public Student() {
        System.out.println("public constructor with no param");
    }

    public Student(char ch) {
        System.out.println("constructor with char " + ch);
    }

    protected Student(String name, int age) {
        System.out.println("name " + name + " age " + age);
    }

    protected Student(Boolean n) {
        System.out.println("protect n " + n);
    }

    private Student(int age) {
        System.out.println("private  age " + age);
    }
}
