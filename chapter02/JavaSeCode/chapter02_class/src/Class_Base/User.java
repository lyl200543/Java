package Class_Base;

/**
 * ClassName: User
 * Package: Class_Base
 * Description:创建于 2025/3/22 15:31
 *
 * @Author lyl
 * @Version 1.0
 */
public class User {
    public static void main (String[] args) {
        User user = new User(2);
        System.out.println(user.age);
    }

    String name;
    int age= 10;   //显式初始化

    User(){}
    User(int a){
          age=a;
    }

}
