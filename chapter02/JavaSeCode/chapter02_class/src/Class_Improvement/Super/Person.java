package Class_Improvement.Super;

/**
 * ClassName: Person
 * Package: Class_Improvement
 * Description:创建于 2025/3/22 20:28
 *
 * @Author lyl
 * @Version 1.0
 */
public class Person {
    String name;
    int age;
    int id=1;

    public Person(){
        System.out.println("Person()...");
    }

    public Person(String name, int age){
        this.name =name;
        this.age=age;
        System.out.println("Person(String name, int age)...");
    }

    public void eat()
    {
        System.out.println("人吃饭");
    }

    public void sleep(){
        System.out.println("人睡觉");
    }
}
