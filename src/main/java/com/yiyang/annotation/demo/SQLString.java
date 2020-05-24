package com.yiyang.annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {

    String name() default "";

    //length of string, eg varchar(30)
    int value() default 0;

    Constraints constraint() default @Constraints;
}
