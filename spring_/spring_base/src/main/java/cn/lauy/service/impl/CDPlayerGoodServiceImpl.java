package cn.lauy.service.impl;

import cn.lauy.annotation.Cold;
import cn.lauy.service.CDPlayerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Lauy
 * @date 2021/3/26
 */
@Component
// @Primary
// @Qualifier("cold")
@Cold("cold")
public class CDPlayerGoodServiceImpl implements CDPlayerService {
    private String title = "good. Pepper's Lonely Hearts Club Band";
    private String good = "The Beatles is good";

    @Override
    public String play() {
        return "Playing " + title + " by " + good;
    }

}
