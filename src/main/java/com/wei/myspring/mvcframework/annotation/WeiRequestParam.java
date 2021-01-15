package com.wei.myspring.mvcframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WeiRequestParam {
    String value() default "";
}
