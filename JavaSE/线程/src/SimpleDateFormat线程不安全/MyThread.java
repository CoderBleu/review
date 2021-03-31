package SimpleDateFormat线程不安全;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class MyThread extends Thread{

    private String dateStr;

    public MyThread(String dateStr) {
        this.dateStr = dateStr;
    }

    @Override
    public void run() {
        Date date = null;
        try {
            date = DateTools.parse(this.dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            DateTools.remove();
        }
        String format = DateTools.format(date);
        System.out.println(Thread.currentThread().getName() + "原始数据：" + this.dateStr
                + "日期类型date：" + date + "格式化后的format：" + format);
    }
}
