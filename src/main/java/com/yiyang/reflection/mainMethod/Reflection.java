package com.yiyang.reflection.mainMethod;

import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws Exception {
        Class studentClass = Class.forName("com.yiyang.reflection.mainMethod.Student");

        Method mainMethod = studentClass.getMethod("main", String[].class);

        mainMethod.invoke(null, (Object) new String[]{"a", "b", "c"});
    }
}
