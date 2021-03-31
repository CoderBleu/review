package cn.lauy.controller;

import cn.lauy.annotation.Cold;
import cn.lauy.bean.CDPlayer;
import cn.lauy.service.CDPlayerService;
import cn.lauy.service.Performance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lauy
 * @date 2021/3/27
 */
@RequestMapping
@RestController
@Slf4j
public class IndexController {

    // @Qualifier("cold")
    @Autowired
    @Cold("cold")
    private CDPlayerService cdPlayerService;

    @Resource
    private Performance performance;

    @Autowired
    private CDPlayer cdPlayer;

    @GetMapping
    public String home() {
        performance.perform();
        return "Hello world!";
    }
}
