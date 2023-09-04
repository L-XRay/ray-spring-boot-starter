package cn.ray.middleware.hystrix.annotation;

import java.lang.annotation.*;

/**
 * @author Ray
 * @date 2023/9/4 15:56
 * @description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoHystrix {

    /**
     * 返回结果
     * @return JSON
     */
    String returnJson() default "";

    /**
     * 超时熔断
     * @return 超时时长
     */
    int timeout() default 0;

}
