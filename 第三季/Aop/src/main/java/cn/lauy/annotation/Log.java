package cn.lauy.annotation;

import java.lang.annotation.*;

/**
 * @author Lauy
 * @date 2021/2/2
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /**
     * 操作模块
     * @return
     */
    String title() default  "my annotation for printing log";

}
