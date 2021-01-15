package com.wei.myspring.mvcframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WeiAutowired {
    String value() default "";
}
