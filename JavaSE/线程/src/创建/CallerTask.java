package 创建;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Lauy
 * @date 2021/3/21
 */
public class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "caller value";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        // FutureTask<String> futureTask = new FutureTask<>(new Runnable() {
        //     @Override
        //     public void run() {
        //         System.out.println(123);
        //     }
        // }, "hello");
        new Thread(futureTask).start();
        try {
            // 等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
