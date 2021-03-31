import java.util.List;

/**
 * @author Lauy
 * @date 2021/2/18
 */
public abstract class Person {
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void helloAbstract() {
        System.out.println("hello");
    }

    // public abstract String home();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
