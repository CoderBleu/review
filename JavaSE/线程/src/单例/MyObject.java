package 单例;

import java.io.Serializable;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class MyObject implements Serializable {

    private static final long serialVersionUID = 1345567872L;

    private static class MyObjectHandler {
        private static final MyObject myObject = new MyObject();
    }

    private MyObject() {
    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }

    // protected Object readResolve() throws ObjectStreamException {
    //     return MyObjectHandler.myObject;
    // }
}
