package Class_Improvement.Super;

/**
 * ClassName: Student
 * Package: Class_Improvement
 * Description:创建于 2025/3/22 20:33
 *
 * @Author lyl
 * @Version 1.0
 */
public class Student extends Person{
    String school;
    int id=2;

    public Student(){
        //省略了super();
        System.out.println("Student()...");
    }

    public Student(String name, int age, String school){
        //省略了super();
//        super(name,age);
        this.school =school;
        System.out.println("Student(String school)...");
    }

    public void eat(){
        System.out.println("学生要吃好饭");
    }

    public void sleep(){
        System.out.println("学生至少要保证8小时的睡眠");
    }

    public void show(){
        this.eat();
        super.eat();
        System.out.println(id);
        System.out.println(super.id);

    }
}
