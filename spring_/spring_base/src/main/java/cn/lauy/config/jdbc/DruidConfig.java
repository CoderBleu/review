package cn.lauy.config.jdbc;

/**
 * @Author Blue
 * @Date 2021/3/28
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Blue
 * @date 2021/3/28
 **/
@Configuration
@PropertySource("classpath:jbdc.properties")
// @ConfigurationProperties(prefix = "spring.datasource.druid.read")
public class DruidConfig {
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @ConfigurationProperties(prefix = "spring.datasource.druid.read")
    @Bean(name = "readDruidDataSource")
    public DataSource readDruidDataSource() {
        return new DruidDataSource();
    }

    @ConfigurationProperties(prefix = "spring.datasource.druid.write")
    @Bean(name = "writeDruidDataSource")
    @Primary
    public DataSource writeDruidDataSource() {
        // DataSource dataSource = DruidDataSourceBuilder.create().build();
        // return dataSource;
        return  new DruidDataSource();
    }


    // @Bean
    // @Primary
    // public DynamicDataSource dataSource(DataSource oneDataSource, DataSource twoDataSource) {
    //     Map<Object, Object> targetDataSources = new HashMap<>(2);
    //     targetDataSources.put(DataSourceNames.ONE, oneDataSource);
    //     targetDataSources.put(DataSourceNames.TWO, twoDataSource);
    //     // 还有数据源,在targetDataSources中继续添加
    //     System.out.println("DataSources:" + targetDataSources);
    //     return new DynamicDataSource(oneDataSource, targetDataSources);
    // }

    //配置Druid后台监控
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        //向里面添加参数
        initParameters.put("loginUsername","admin"); //登录名
        initParameters.put("loginPassword","admin"); //登录密码
        initParameters.put("allow","");//默认就是允许所有访问
        //设置
        bean.setInitParameters(initParameters);
        return bean;
    }

    //配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}