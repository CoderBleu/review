package cn.lauy.service;

import cn.lauy.MainApplication;
import cn.lauy.bean.CDPlayer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Lauy
 * @date 2021/3/26
 */
@SpringBootTest(classes = MainApplication.class)
class CDPlayerServiceTest {

    // @Autowired
    private CDPlayerService cdPlayerService;

    // @Autowired
    public void setCdPlayerService(CDPlayerService cdPlayerService) {
        this.cdPlayerService = cdPlayerService;
    }

    @Autowired
    public CDPlayerServiceTest(CDPlayerService cdPlayerService) {
        this.cdPlayerService = cdPlayerService;
    }

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cdPlayerService);

        ApplicationContext context = new AnnotationConfigApplicationContext(cn.lauy.config.CDPlayerConfig.class);

        CDPlayer player = (CDPlayer)context.getBean("player");
        System.out.println("player：" + player);
        CDPlayer cdPlayer = (CDPlayer)context.getBean("cdPlayer");
        System.out.println("cdPlayer：" + cdPlayer);
        // UserInfo userInfo = (UserInfo)context.getBean("userInfo");
        // System.err.println("userInfo：" + userInfo);
    }
}
