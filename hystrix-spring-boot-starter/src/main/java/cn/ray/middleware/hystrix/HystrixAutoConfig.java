package cn.ray.middleware.hystrix;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ray
 * @date 2023/9/4 16:26
 * @description
 */
@Configuration
public class HystrixAutoConfig {

    @Bean(name = "hystrix-point")
    @ConditionalOnMissingBean
    public DoHystrixPoint point() {
        return new DoHystrixPoint();
    }

}
