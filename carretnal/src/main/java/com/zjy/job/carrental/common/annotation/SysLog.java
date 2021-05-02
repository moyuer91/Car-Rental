package com.zjy.job.carrental.common.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SysLog {

    /**
     * 描述
     *
     * @return
     */
    public String value();

    /**
     * 是否持久化
     *
     * @return
     */
    public boolean persistence() default false;
}
