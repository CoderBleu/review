package cn.lauy.config;

import cn.lauy.bean.CDPlayer;
import cn.lauy.service.CDPlayerService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Lauy
 * @date 2021/3/26
 */
@Configuration
public class CDConfig {


    /**
     * cdPlayer() 方法请求方法 cdPlayerService 作为参数
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 原型Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(() -> "cdPlayer");
    }

}
