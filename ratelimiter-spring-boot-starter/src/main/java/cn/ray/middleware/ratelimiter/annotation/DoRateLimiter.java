package cn.ray.middleware.ratelimiter.annotation;

import java.lang.annotation.*;

/**
 * @author Ray
 * @date 2023/9/4 18:24
 * @description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoRateLimiter {

    /**
     * 限流量
     */
    double permitsPerSecond() default 0D;

    /**
     * 超过限流量后返回结果
     */
    String returnJson() default "";

}
