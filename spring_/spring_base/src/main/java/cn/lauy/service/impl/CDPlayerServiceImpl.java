package cn.lauy.service.impl;

import cn.lauy.service.CDPlayerService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Lauy
 * @date 2021/3/26
 */
@Component
public class CDPlayerServiceImpl implements CDPlayerService {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public String play() {
        return "Playing " + title + " by " + artist;
    }

}
