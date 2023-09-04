package cn.ray.middleware.ratelimiter.valve;

import cn.ray.middleware.ratelimiter.annotation.DoRateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author Ray
 * @date 2023/9/4 15:59
 * @description
 */
public interface IValveService {

    Object access(ProceedingJoinPoint jp, Method method, DoRateLimiter doRateLimiter, Object[] args) throws Throwable;

}
