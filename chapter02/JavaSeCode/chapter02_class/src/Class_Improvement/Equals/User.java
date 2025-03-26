package Class_Improvement.Equals;

import java.util.Objects;

/**
 * ClassName: User
 * Package: Class_Improvement.Equals
 * Description:创建于 2025/3/23 15:34
 *
 * @Author lyl
 * @Version 1.0
 */
public class User {
    String name;
    int age;

    public User(String name,int age){
        this.name =name;
        this.age =age;
    }
//    public boolean equals (Object obj) {
//        if(this==obj)
//            return true;
//        if(obj instanceof User){
//            User newobj=(User)obj;
//            return this.name.equals(newobj.name) && this.age== newobj.age;
//        }
//        return false;
//    }


    //自动生成
    @Override
    public final boolean equals (Object o) {
        if (! (o instanceof User user)) return false;

        return age == user.age && Objects.equals(name , user.name);
    }

    //重写toString()
//    public String toString() {
//        return "User{name="+name+",age="+age+"}";
//    }


    @Override
    public String toString () {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
