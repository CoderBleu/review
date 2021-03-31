package 指令重排;

import sun.misc.Contended;

/**
 * @author Lauy
 * @date 2021/3/22
 */
public class Main {
    private static int num = 0;

    private static boolean ready = false;

    public static void main(String[] args) {
       try {
           WriteThread writeThread = new WriteThread();
           writeThread.start();

           ReadThread readThread = new ReadThread();
           readThread.start();

           Thread.sleep(1000);
           readThread.interrupt();
       } catch(Exception e) {
           e.printStackTrace();
       }
    }

    @Contended
    static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2; // (3)
            ready = true; // (4)
            System.out.println("WriteThread set over...");
        }
    }

    static class ReadThread extends Thread {
        @Override
        public void run() {
            if (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }
            }
            System.out.println("ReadThread read over...");
        }
    }
}
