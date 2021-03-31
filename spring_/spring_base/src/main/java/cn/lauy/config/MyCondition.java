package cn.lauy.config;

import cn.lauy.bean.CDPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Lauy
 * @date 2021/3/27
 * 有条件的bean
 */
public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        CDPlayer cdPlayer = (CDPlayer)context.getBeanFactory().getBean("cdPlayer");
        return env.containsProperty("magic") || cdPlayer != null;
    }
}
