package cn.ray.middleware.ratelimiter.valve.impl;

import cn.ray.middleware.ratelimiter.valve.IValveService;
import cn.ray.middleware.ratelimiter.annotation.DoRateLimiter;
import cn.ray.middleware.ratelimiter.constants.Constants;
import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author Ray
 * @date 2023/9/4 18:44
 * @description
 */
public class RateLimiterValve implements IValveService {

    @Override
    public Object access(ProceedingJoinPoint jp, Method method, DoRateLimiter doRateLimiter, Object[] args) throws Throwable {
        // 判断是否开启
        if (0 == doRateLimiter.permitsPerSecond()) return jp.proceed();

        String clazzName = jp.getTarget().getClass().getName();
        String methodName = method.getName();

        String key = clazzName + "." + methodName;

        if (null == Constants.rateLimiterMap.get(key)) {
            Constants.rateLimiterMap.put(key, RateLimiter.create(doRateLimiter.permitsPerSecond()));
        }

        RateLimiter rateLimiter = Constants.rateLimiterMap.get(key);
        if (rateLimiter.tryAcquire()) {
            return jp.proceed();
        }

        return JSON.parseObject(doRateLimiter.returnJson(), method.getReturnType());
    }

}
