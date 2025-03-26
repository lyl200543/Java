package Class_Improvement.This;

/**
 * ClassName: ThisTest
 * Package: Class_Improvement
 * Description:创建于 2025/3/22 17:18
 *
 * @Author lyl
 * @Version 1.0
 */
public class ThisTest {
    public static void main (String[] args) {
        User user=new User("lyl",19);
        System.out.println(user.name +" "+user.age );
    }
}
class User {
    String name;
    int age;

    User(){

    }
    User(String name){
        this();
        this.name =name;
    }
    User(String name,int age){
        this(name);
        this.age =age;
    }

}
