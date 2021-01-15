package com.wei.myspring.mvcframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WeiRequestMapping {
    String value() default "";
}
