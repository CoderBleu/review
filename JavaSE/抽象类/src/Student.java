/**
 * @author Lauy
 * @date 2021/2/18
 */
public interface Student {

    void study();

    static String score() {
        return "score=98.5";
    }

    final static String NAME = "JAVA";

    /**
     * JDK 1.8允许给接口添加非抽象的方法实现，但必须使用default关键字修饰
     */
    default void play() {
        System.out.println("学生正在玩耍");
    }
}
