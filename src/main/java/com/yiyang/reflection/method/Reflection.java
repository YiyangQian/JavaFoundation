package com.yiyang.reflection.method;

import java.lang.reflect.Method;

/**
 * 获取成员方法并调用：
 *
 * 1.批量的：
 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * 		public Method getMethod(String name,Class<?>... parameterTypes):
 * 					参数：
 * 						name : 方法名；
 * 						Class ... : 形参的Class类型对象
 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 * 	 调用方法：
 * 		Method --> public Object invoke(Object obj,Object... args):
 * 					参数说明：
 * 					obj : 要调用方法的对象；
 * 					args:调用方式时所传递的实参；
 */

public class Reflection {
    public static void main(String[] args) throws Exception {
        Class studentClass = Class.forName("com.yiyang.reflection.method.Student");

        System.out.println("--- get public methods ---");
        Method[] methods = studentClass.getMethods();
        for(Method method: methods) {
            System.out.println(method);
        }

        System.out.println("--- get all methods ---");
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method method: declaredMethods) {
            System.out.println(method);
        }

        System.out.println("--- get public method and call ---");
        Method method1 = studentClass.getMethod("method1", String.class);
        System.out.println(method1);
        Object o = studentClass.getConstructor().newInstance();
        method1.invoke(o, "invokedMethod1");

        System.out.println("--- get private method and call ---");
        Method method4 = studentClass.getDeclaredMethod("method4", int.class);
        System.out.println(method4);
        method4.setAccessible(true);
        Object result = method4.invoke(o, 999);
        System.out.println("returned value: " + result);
    }
}
