package com.yiyang.reflection.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strArrayList = new ArrayList<>();
        strArrayList.add("str1");
        strArrayList.add("str2");
//        strArrayList.add(100);

        Class c = strArrayList.getClass();
        Method m = c.getMethod("add", Object.class);

        m.invoke(strArrayList, 100);

        for(Object o: strArrayList) {
            System.out.println(o);
        }
    }
}
