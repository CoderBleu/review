package cn.lauy.config;

import cn.lauy.bean.CDPlayer;
import cn.lauy.service.CDPlayerService;
import cn.lauy.service.impl.CDPlayerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Lauy
 * @date 2021/3/26
 */
// @ComponentScan(basePackages = "cn.lauy")
// @Import(CDConfig.class)
@ImportResource("classpath:LoadBeanConfig.xml")
@Configuration
public class CDPlayerConfig {

    /**
     * 默认情况下，bean 的 ID 与带有 @Bean 注解的方法名是一样的
     */
    @Bean
    public CDPlayerService cdPlayerService() {
        return new CDPlayerServiceImpl();
    }

    /**
     * 如果你想为其设置成一个不同的名字的话，那么可以重命名该方法，也可以通过 name 属性指定一个不同的名字。
     */
    @Conditional(MyCondition.class)
    @Bean("cDPlayerServiceName")
    public CDPlayerService cdPlayerServiceSpecifyName() {
        return new CDPlayerServiceImpl();
    }


    // @Bean
    // public CDPlayerService cdPlayerGoodService() {
    //     return new CDPlayerGoodServiceImpl();
    // }
    /**
     * cdPlayer() 方法请求方法 cdPlayerService 作为参数
     */
    // @Bean
    // public CDPlayer cdPlayer() {
    //     return new CDPlayer(cdPlayerService());
    // }

    /* 没有装配 */
    public CDPlayer cdPlayer123() {
        return new CDPlayer(cdPlayerService());
    }
}
