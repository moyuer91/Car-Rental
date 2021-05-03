package com.zjy.job.carrental.common.lock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁切面，可在事务方法前加锁，优先级高于spring事务切面
 */
@Component
@Scope
@Aspect
@Order(1)
public class LockAspect {


    //创建lock锁的对象
    private static Lock lock = new ReentrantLock(true);

    // service 切入点
    @Pointcut("@annotation(com.zjy.job.carrental.common.lock.ServiceLock)")
    public void lockAspect(){

    }

    @Around("lockAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 加锁动作
        lock.lock();
        Object obj = null;
        try {
            // 业务执行地方
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            // 业务执行结束，必须释放锁
            lock.unlock();
        }
        return obj;
    }
}










