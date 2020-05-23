package com.yiyang.reflection.demo1;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName(getValue("className"));
        Method method = c.getMethod(getValue("methodName"));
        method.invoke(c.getConstructor().newInstance());
    }

    private static String getValue(String key) throws IOException {
        Properties properties = new Properties();
        FileReader in = new FileReader("src/main/java/com/yiyang/reflection/demo1/settings.txt");
        properties.load(in);
        in.close();
        return (String) properties.get(key);
    }
}
