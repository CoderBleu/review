>一个类要创建实例需要先加载并初始化该类
​ main方法所在的类需要先加载和初始化
一个子类要初始化需要先初始化父类
一个类初始化就是执行 clinit 方法
​ clinit 方法由静态类变量显示赋值代码和静态代码块组成
​ 类变量显示赋值代码和静态代码块代码从上到下执行
​ clinit 方法只调用一次
> 
> 静态代码块 和 静态方法 执行顺序遵循自上而下顺序

运行输出：
```java
父类静态代码块
父类静态方法
子类的静态方法
子类的静态代码块
子类重写的test方法
非静态代码块
父类构造方法
子类重写的test方法
子类的非静态代码块
子类的无参构造方法

子类重写的test方法
非静态代码块
父类构造方法
子类重写的test方法
子类的非静态代码块
子类的无参构造方法
```