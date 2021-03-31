package 管道流;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author Lauy
 * @date 2021/3/17
 */
public class ReadThread extends Thread{

    private PipedReader reader;
    private ReadData readData;

    public ReadThread(ReadData readData, PipedReader reader) {
        this.readData = readData;
        this.reader = reader;
    }

    @Override
    public void run() {
        readData.readMethod(reader);
    }
}
