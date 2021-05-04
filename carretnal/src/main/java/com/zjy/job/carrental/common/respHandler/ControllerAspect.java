package com.zjy.job.carrental.common.respHandler;

import com.zjy.job.carrental.common.exception.ServiceException;
import com.zjy.job.carrental.domain.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 处理和包装异常
 */
@Aspect
@Component
public class ControllerAspect {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
//
//    @Pointcut("execution(* com.dm.visaservice.controller.*.*(..)) && args(pageNum,pageSize,..)")
//    private void controllerPagingCutPoint(Integer pageNum, Integer pageSize) {
//
//    }



//    @Around(value = "controllerPagingCutPoint(pageNum,pageSize)")
//    public Object handlerControllerPagingMethod(ProceedingJoinPoint pjp,Integer pageNum,Integer pageSize) {
//        Result<?> result;
//        logger.info("conroller切面分页方法开始");
//        try {
//            Object[] args = pjp.getArgs();
//            args[0]=CommonUtil.handlePageNum(pageNum);
//            args[1]=CommonUtil.handlePageSize(pageSize);
//            result = (Result<?>) pjp.proceed();
//        } catch (Throwable e) {
//            result = handlerException(pjp, e);
//        }
//        logger.info("conroller分页方法切面结束");
//        return result;
//    }

    @Pointcut("execution(* com.zjy.job.carrental.controller.*.*(..))")
    private void controllerCutPoint() {

    }
    @Around(value = "controllerCutPoint()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        Object result;
        logger.info("conroller切面开始");
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }
        logger.info("conroller切面结束");
        return result;
    }

    private Result<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result<?> result = new Result();

        // 已知异常
        if (e instanceof ServiceException) {
            result.setMsg(e.getLocalizedMessage());
            result.setErrno(Result.FAIL);
            result.setSuccess(false);
        } else {
            logger.error(pjp.getSignature() + " error ", e);
            //TODO 未知的异常，应该格外注意，可以发送邮件通知等
            result.setMsg(e.toString());
            result.setErrno(Result.FAIL);
            result.setSuccess(false);
        }

        return result;
    }
}
