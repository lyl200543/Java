package Class_Advanced.Abstract;

/**
 * ClassName: Employee
 * Package: Class_Advanced.Abstract
 * Description:创建于 2025/3/26 8:36
 *
 * @Author lyl
 * @Version 1.0
 */
public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee () {
    }

    public Employee (String name , int number , MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public abstract double earnings();

    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toString()+
                '}';
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getNumber () {
        return number;
    }

    public void setNumber (int number) {
        this.number = number;
    }

    public MyDate getBirthday () {
        return birthday;
    }

    public void setBirthday (MyDate birthday) {
        this.birthday = birthday;
    }
}

