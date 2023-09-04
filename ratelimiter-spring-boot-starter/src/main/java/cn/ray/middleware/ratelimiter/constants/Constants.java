package cn.ray.middleware.ratelimiter.constants;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ray
 * @date 2023/9/4 18:56
 * @description
 */
public class Constants {

    public static Map<String, RateLimiter> rateLimiterMap = Collections.synchronizedMap(new HashMap<>());

}
