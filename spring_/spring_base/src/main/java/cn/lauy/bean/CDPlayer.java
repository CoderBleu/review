package cn.lauy.bean;

import cn.lauy.service.CDPlayerService;

/**
 * @author Lauy
 * @date 2021/3/26
 */
public class CDPlayer {
    private CDPlayerService cdPlayerService;

    public CDPlayer(CDPlayerService cdPlayerService) {
        this.cdPlayerService = cdPlayerService;
    }

    public CDPlayer() {
    }
}
