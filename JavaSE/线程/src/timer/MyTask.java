package timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("运行了，时间为：" + new Date());
    }
}
