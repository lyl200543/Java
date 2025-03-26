package Class_Improvement.Equals;

/**
 * ClassName: EqualsTest
 * Package: Class_Improvement
 * Description:创建于 2025/3/23 15:33
 *
 * @Author lyl
 * @Version 1.0
 */
public class EqualsTest {
    public static void main (String[] args) {
        User u1 =new User("lyl",19);
        User u2 =new User("lyl",19);
        //没重写（false）   重写（true）
        System.out.println(u1.equals(u2));

        System.out.println(u1);
        System.out.println(u1.toString());
    }
}
