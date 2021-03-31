package 管道流;

import java.io.*;
import java.util.UUID;

/**
 * @author Lauy
 * @date 2021/3/17
 */
class WriteData {
    public void writeMethod(PipedWriter out) {
        try {
            System.out.println("write：");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 300; i++) {
                String outData = UUID.randomUUID().toString().replace("-", "") + (i + 1);
                stringBuffer.append(outData);
                out.write(outData);
            }
            System.err.println(stringBuffer);
            System.out.println();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadData {
    public void readMethod(PipedReader input) {
        try {
            System.out.println("read：");
            char[] byteArray = new char[20];
            int read = input.read(byteArray);
            while (read != -1) {
                String newData = new String(byteArray, 0, read);
                System.out.println("newData：" + newData);
                read = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
