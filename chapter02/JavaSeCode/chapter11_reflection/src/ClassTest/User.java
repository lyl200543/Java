package ClassTest;

/**
 * ClassName: User
 * Package: ClassTest
 * Description:创建于 2025/4/12 10:30
 *
 * @Author lyl
 * @Version 1.0
 */
public class User {
    private String name;
    private int age;

    public User () {
    }

    public User (String name , int age) {
        this.name = name;
        this.age = age;
    }

    public void show () {
        System.out.println("我是使用者");
    }

    @Override
    public String toString () {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
