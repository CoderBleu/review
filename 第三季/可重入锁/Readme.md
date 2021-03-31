1. synchronized 验证锁的可重入性

输出：
>Thread-0 helloA()
> 
>Thread-0 helloB()

>结果解析：如果同一线程，锁不可重入的话，helloB 需要等待 helloA 释放 obj 锁，如此一来，helloB 无法进行锁的获取，最终造成无限等待，无法正常执行。此处说明了 synchronized 关键字的可重入性，因此能够正常进行两个方法的执行。
> 
> 

2. ReentrantLock 一样是可重入锁
>Thread-0 helloA()
> 
>Thread-0 helloB()

>结果解析：ReentrantLock 一样是可重入锁，试验成功。