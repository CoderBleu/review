package cn.lauy.service.impl;

import cn.lauy.service.Performance;
import org.springframework.stereotype.Service;

/**
 * @author Lauy
 * @date 2021/3/27
 */
@Service
public class PerformanceImpl implements Performance {
    @Override
    public void perform() {
        System.out.println("我调用了方法 perform");
    }
}
