package com.yiyang.annotation.reflect;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@InheritedAnnotation
class A{}

@NoInheritedAnnotation
public class ReflectDemo extends A {
    public static void main(String[] args) {
        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;

        InheritedAnnotation inheritedAnnotation = reflectDemoClass.getAnnotation(InheritedAnnotation.class);
        System.out.println("InheritedAnnotation: " + inheritedAnnotation);

        Annotation[] allAnnotations = reflectDemoClass.getAnnotations();
        System.out.println("all annotations: " + Arrays.toString(allAnnotations));

        Annotation[] declaredAnnotations = reflectDemoClass.getDeclaredAnnotations();
        System.out.println("all declared annotations: " + Arrays.toString(declaredAnnotations));

        boolean isInheritedAnnotationPresent = reflectDemoClass.isAnnotationPresent(InheritedAnnotation.class);
        System.out.println("isInheritedAnnotationPresent: " + isInheritedAnnotationPresent);
        boolean isNoInheritedAnnotationPresent = reflectDemoClass.isAnnotationPresent(NoInheritedAnnotation.class);
        System.out.println("isNoInheritedAnnotationPresent: " + isNoInheritedAnnotationPresent);
    }
}
