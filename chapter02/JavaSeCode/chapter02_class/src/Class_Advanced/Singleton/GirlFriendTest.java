package Class_Advanced.Singleton;

/**
 * ClassName: GirlFriend
 * Package: Class_Advanced.Singleton
 * Description:创建于 2025/3/24 11:28
 *
 * @Author lyl
 * @Version 1.0
 */

//懒汉式：
public class GirlFriendTest {
    public static void main (String[] args) {
        GirlFriend g1=GirlFriend.getInstance();
        GirlFriend g2=GirlFriend.getInstance();
        System.out.println(g1==g2);
    }
}

class GirlFriend{
    //1.类的构造器私有化
    private GirlFriend(){

    }

    //2.在类的内部先声明当前类的实例
    //4.此属性也必须声明为static（才能被静态方法调用）
    private static GirlFriend instance=null;

    //3.使用getXxx()方法获取当前类的实例，必须声明为static
    public static GirlFriend getInstance(){
        if(instance==null){
            instance=new GirlFriend();
        }
        return instance;
    }
}