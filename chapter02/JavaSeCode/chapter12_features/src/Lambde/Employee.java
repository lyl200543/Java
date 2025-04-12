package Lambde;

/**
 * ClassName: Employee
 * Package: Lambde
 * Description:创建于 2025/4/12 20:35
 *
 * @Author lyl
 * @Version 1.0
 */
public class Employee {
    private String name;
    public int age;

    public Employee () {
    }

    public Employee (String name) {
        this.name = name;
    }

    public Employee (String name , int age) {
        this.name = name;
        this.age = age;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    @Override
    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
