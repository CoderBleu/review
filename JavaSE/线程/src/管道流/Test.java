package 管道流;

import java.io.*;

/**
 * @author Lauy
 * @date 2021/3/17
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        PipedReader reader = new PipedReader();
        PipedWriter out = new PipedWriter();
        // out.connect(reader);
        reader.connect(out);

        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();

        ReadThread readThread = new ReadThread(readData, reader);
        readThread.start();

        Thread.sleep(100);

        WriteThread writeThread = new WriteThread(writeData, out);
        writeThread.run();
    }
}
