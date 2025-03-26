package Class_Advanced.Inner;

/**
 * ClassName: Inner
 * Package: Class_Advanced
 * Description:创建于 2025/3/26 17:27
 *
 * @Author lyl
 * @Version 1.0
 */
public class InnerTest {
    public static void main (String[] args) {
        //创建静态的成员内部类的实例
        Person.Dog dog=new Person.Dog();
        dog.eat();
        //创建非静态的成员内部类的实例
        Person person = new Person();
        Person.Bird bird=person.new Bird();
        bird.eat();
        bird.show("黄鹂");
        bird.show1();
    }
}

class Person{
    String name="Tom";
    int age=1;
    //成员内部类
    static class Dog{
        public void eat(){
            System.out.println("狗吃骨头");
        }
    }

    class Bird{
        String name="啄木鸟";
        public void eat(){
            System.out.println("鸟吃虫子");
        }
        void show(String name){
            System.out.println(name); //形参的name
            System.out.println(age);
            System.out.println(this.name); //Bird类的name
            System.out.println(Person.this.name); //Person类的name
        }

        void show1(){
            eat();
            this.eat();
            Person.this.eat();
        }
    }

    public void eat(){
        System.out.println("人吃饭");
    }
    //局部内部类
    public void method(){
        class InnerClass1{

        }
    }

    Person(){
        class InnerClass1{

        }
    }
    {
        class InnerClass1{

        }
    }
}