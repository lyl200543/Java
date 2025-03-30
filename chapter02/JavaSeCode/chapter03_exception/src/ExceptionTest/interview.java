package ExceptionTest;

/**
 * ClassName: interview
 * Package: ExceptionTest
 * Description:创建于 2025/3/30 14:35
 *
 * @Author lyl
 * @Version 1.0
 */
public class interview {
    public static void main(String[] args) {
        int result = test(10);
        System.out.println(result);
    }
    public static int test(int num){
        try {
            return num;
        }catch(NumberFormatException e){
            return num--;
        } finally {
            System.out.println("test结束");
//            return ++num;  //11
            ++num;  //10
        }
    }
}
