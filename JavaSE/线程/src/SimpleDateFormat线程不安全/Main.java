package SimpleDateFormat线程不安全;

import threadlocal.ThreadLocalSon;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        String[] dates = {"2020-08-12", "2019-08-14", "2021-02-25", "2018-07-06", "2019-02-08", "2020-02-02"};
        MyThread[] myThreads = new MyThread[6];

        for (int i = 0; i < dates.length; i++) {
            myThreads[i] = new MyThread(dates[i]);
        }
        for (int i = 0; i < dates.length; i++) {
            myThreads[i].start();
        }
    }
}
