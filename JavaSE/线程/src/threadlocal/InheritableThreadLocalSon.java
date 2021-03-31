package threadlocal;

import java.util.UUID;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class InheritableThreadLocalSon extends InheritableThreadLocal{

    @Override
    protected Object initialValue() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
