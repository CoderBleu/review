package cn.lauy.test;

import cn.lauy.service.ServiceA;
import cn.lauy.service.ServiceB;

/**
 * @author Lauy
 * @date 2021/1/30
 */
public class TestForConstruct {
    public static void main(String[] args) {
        // 构造器注入的循环依赖问题！
        // new ServiceA(new ServiceB(new ServiceA()));
    }
}
