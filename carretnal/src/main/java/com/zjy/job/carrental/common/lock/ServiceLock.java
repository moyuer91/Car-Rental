package com.zjy.job.carrental.common.lock;

import java.lang.annotation.*;

/**
 * 自定义注解，实现锁上移
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLock {
    String description() default "";
}
