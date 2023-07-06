package com.smartapps.loginwithspring.utills;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AllowEmpty {
    boolean value() default true;
    String name() default "";
    UtilsEnum en() default UtilsEnum.CAPITAL;
}