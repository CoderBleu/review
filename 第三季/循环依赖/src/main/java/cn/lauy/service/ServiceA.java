package cn.lauy.service;

import org.springframework.stereotype.Component;

/**
 * @author Lauy
 * @date 2021/1/30
 */
@Component
public class ServiceA {

    private ServiceB serviceB;

    // 构造器注入，可能导致循环依赖
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    //setter注入
    // public void setServiceB(ServiceB serviceB) {
    //     this.serviceB = serviceB;
    //     System.out.println("A 里面设置了 B");
    // }
}
