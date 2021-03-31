package cn.lauy.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lauy
 * @date 2021/3/27
 */
@Configuration
public class ServerPortConfig implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    // @Autowired // 使用@Bean注解找不到,可能是方法重写有影响
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8099);
    }

}
