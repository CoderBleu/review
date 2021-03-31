package cn.lauy.config;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.test.context.ActiveProfiles;


/**
 * @author Lauy
 * @date 2021/3/27
 */
@ActiveProfiles("dev")
@Configuration
public class DataSourceConfig{

    // @Bean(destroyMethod = "shutdown")
    // @Profile("dev")
    // public DataSource embeddedDataSource() {
    //     return new EmbeddedDatabaseBuilder()
    //             .setType(EmbeddedDatabaseType.H2)
    //             .addScript("classpath:schema.sql")
    //             .addScript("classpath:test-data.sql")
    //             .build();
    // }
    //
    // @Bean
    // @Profile("prod")
    // public DataSource jndiDataSource() {
    //     JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
    //     jndiObjectFactoryBean.setJndiName("jdbc/myDS");
    //     jndiObjectFactoryBean.setResourceRef(true);
    //     jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
    //     return (DataSource) jndiObjectFactoryBean.getObject();
    // }
}
