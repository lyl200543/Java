package Class_Advanced;

/**
 * ClassName: KeyTest
 * Package: Class_Advanced
 * Description:创建于 2025/3/29 21:01
 *
 * @Author lyl
 * @Version 1.0
 */
public class KeyTest {
    public static void main (String[] args) {
        try {
            Integer integer = Integer.valueOf(1);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        int count = 5;
        while ((count--) > 0) {
            System.out.println("hello");
        }
    }
}
