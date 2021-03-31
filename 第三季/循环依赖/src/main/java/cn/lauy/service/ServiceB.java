package cn.lauy.service;

import org.springframework.stereotype.Component;

/**
 * @author Lauy
 * @date 2021/1/30
 */
@Component
public class ServiceB {
    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    // public void setServiceA(ServiceA serviceA) {
    //     this.serviceA = serviceA;
    //     System.out.println("B 里面设置了 A");
    // }
}
