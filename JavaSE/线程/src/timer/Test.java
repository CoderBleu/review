package timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.SimpleFormatter;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Test {
    // 推荐：ScheduledExecutorService
    private static Timer timer = new Timer(true);

    public static void main(String[] args) throws ParseException {
        MyTask myTask = new MyTask();

        String str = "2021-03-18 15:12:00";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatter.parse(str);
        timer.schedule(myTask, date);
    }
}
