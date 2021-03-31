import java.util.*;

/**
 * @author Lauy
 * @date 2021/2/18
 */
public class TestAbstract {
    public static void main(String[] args) {
        // 将此类设为抽象类(可以 new,但不能被实例化)
        // Person person = new Person() {
        //
        //     @Override
        //     public String home() {
        //         return "一个子类继承一个抽象类，则子类必须实现父类抽象方法，否则子类也必须定义为抽象类";
        //     }
        // };
        // person.setName("Hello World");
        // System.out.println(person);
        //
        // System.err.println(Student.score());
        //
        // Student student = new Student() {
        //     @Override
        //     public void study() {
        //
        //     }
        //
        //     @Override
        //     public void play() {
        //         System.out.println("Test - 学生正在玩耍");
        //     }
        // };
        // student.play();
        //
        // System.out.printf("%s", Student.NAME);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        HashSet<Object> s = new HashSet<>();
        s.add(null);
        s.add(null);

    }

}
