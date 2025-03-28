package Class_Advanced.Annotation;

/**
 * ClassName: AnnotationTest
 * Package: Class_Advanced.Annotation
 * Description:创建于 2025/3/28 20:39
 *
 * @Author lyl
 * @Version 1.0
 */
public class AnnotationTest {
    public static void main (String[] args) {
        Student student =new Student();
        student.sleep();

    }
}

@MyAnnotation(value="calss")
class Person{
    //@SuppressWarnigns抑制编译器警告
    @SuppressWarnings ("unused")
    String name;
    int age;
    public void eat() {
        System.out.println("人吃饭");
    }
}

class Student extends Person{
    //@Override注解：检查是否重写方法，只能修饰方法
    @Override
    public void eat(){
        System.out.println("学生吃饭");
    }

    //@Deprecated注解：代表方法已经过时，但为了之前使用该方法的程序仍能运行，故保留
    @Deprecated
    void sleep(){
        System.out.println("学生睡觉");
    }
}