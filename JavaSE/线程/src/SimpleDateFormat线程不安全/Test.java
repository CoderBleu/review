package SimpleDateFormat线程不安全;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lauy
 * @date 2021/3/25
 */
public class Test {

    static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {
        String[] dates = {"2020-08-12", "2019-08-14", "2021-02-25", "2018-07-06", "2019-02-08", "2020-02-02"};

        for (int i = 0; i < dates.length; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Date date = threadLocal.get().parse(dates[finalI]);
                    System.out.println("date：" + date);

                    System.out.println("format：" + threadLocal.get().format(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                } finally {
                    // 使用完毕记得清楚，避免内存泄露
                    threadLocal.remove();
                }
            }).start();
        }
    }
}
