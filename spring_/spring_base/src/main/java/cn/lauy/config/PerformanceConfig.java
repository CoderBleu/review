package cn.lauy.config;

import cn.lauy.aspect.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author Lauy
 * @date 2021/3/27
 */
@Configuration
@EnableAspectJAutoProxy // 启用自动代理功能： 尽管使用的是@AspectJ注解，但本质上还是Spring 基于代理的切面
@Component
public class PerformanceConfig {
    @Bean
    public Audience audience() {
        return new Audience();
    }
}
