package cn.lauy.config;

/**
 * @author Lauy
 * @date 2021/3/27
 * 注入外部的值
 */

import cn.lauy.bean.Person;
import cn.lauy.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:LoadBeanFromOuter.properties")
public class ExpressiveConfig {

    @Autowired
    Environment env;

    @Value("${person.id}")
    private long id;
    @Value("${person.gender}")
    private char gender;

    @Bean
    public UserInfo loadUserInfo() {
        env.getProperty("user.id");
        env.getProperty("user.userName");

        return new UserInfo(
                env.getProperty("user.id", "201614100130"),
                env.getProperty("user.userName", "lauy")
        );
    }

    @Bean
    public Person loadPersonByValue() {
        return new Person(this.id, this.gender);
    }
}
