package 管道流;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author Lauy
 * @date 2021/3/17
 */
public class WriteThread implements Runnable{

    private PipedWriter writer;
    private WriteData writeData;

    public WriteThread(WriteData writeData, PipedWriter writer) {
        this.writeData = writeData;
        this.writer = writer;
    }

    @Override
    public void run() {
        writeData.writeMethod(writer);
    }
}
