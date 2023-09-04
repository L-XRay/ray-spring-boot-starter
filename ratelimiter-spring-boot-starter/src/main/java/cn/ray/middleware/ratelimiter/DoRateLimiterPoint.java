package cn.ray.middleware.ratelimiter;

import cn.ray.middleware.ratelimiter.valve.IValveService;
import cn.ray.middleware.ratelimiter.valve.impl.RateLimiterValve;
import cn.ray.middleware.ratelimiter.annotation.DoRateLimiter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Ray
 * @date 2023/9/4 19:03
 * @description
 */
@Aspect
@Component
public class DoRateLimiterPoint {

    @Pointcut("@annotation(cn.ray.middleware.ratelimiter.annotation.DoRateLimiter)")
    public void aopPoint() {
    }

    @Around("aopPoint() && @annotation(doRateLimiter)")
    public Object doRouter(ProceedingJoinPoint jp, DoRateLimiter doRateLimiter) throws Throwable {
        IValveService valveService = new RateLimiterValve();
        return valveService.access(jp, getMethod(jp), doRateLimiter, jp.getArgs());
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return jp.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

}
