package com.yiyang.annotation.inherited;

import java.lang.annotation.*;

@InheritedAnnotation
class A{}

class B extends A{}

@NoInheritedAnnotation
class C{}

class D extends C{};

public class InheritedSample {
    public static void main(String[] args) {
        System.out.println("--- B instance annotations ---");
        A bInstance = new B();
        Annotation[] annotations = bInstance.getClass().getAnnotations();
        for(Annotation annotation: annotations) {
            System.out.println(annotation);
        }

        System.out.println("--- D instance annotations ---");
        C dInstance = new D();
        annotations = dInstance.getClass().getAnnotations();
        for(Annotation annotation: annotations) {
            System.out.println(annotation);
        }
    }
}
