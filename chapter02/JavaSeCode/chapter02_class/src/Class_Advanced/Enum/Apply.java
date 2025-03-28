package Class_Advanced.Enum;

/**
 * ClassName: Apply
 * Package: Class_Advanced.Enum
 * Description:创建于 2025/3/28 19:26
 *
 * @Author lyl
 * @Version 1.0
 */
public class Apply {
    public static void main (String[] args) {
        Employee employee =new Employee(19,"lyl",Status.BUSY);
        System.out.println(employee);
    }
}

enum Status{
    BUSY,VACATION,DISMISSION;
}

class Employee{
    String name;
    int age;
    Status status;

    public Employee () {
    }

    public Employee (int age , String name , Status status) {
        this.age = age;
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}