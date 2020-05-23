package com.yiyang.reflection.method;

public class Student {

    public void method1(String s) {
        System.out.println("public method1 called with params: " + s);
    }

    protected void method2() {
        System.out.println("protected method2 called");
    }

    void method3() {
        System.out.println("default method3 called");
    }

    private String method4(int age) {
        System.out.println("private method4 called with param: " + age);
        return "method4";
    }
}
