package cn.ray.middleware.ratelimiter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ray
 * @date 2023/9/4 19:07
 * @description
 */
@Configuration
public class RateLimiterAutoConfig {

    @Bean(name = "rateLimiter-point")
    @ConditionalOnMissingBean
    public DoRateLimiterPoint point() {
        return new DoRateLimiterPoint();
    }
}
