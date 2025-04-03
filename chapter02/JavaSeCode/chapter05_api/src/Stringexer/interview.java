package Stringexer;

/**
 * ClassName: interview
 * Package: exer
 * Description:创建于 2025/4/3 16:09
 *
 * @Author lyl
 * @Version 1.0
 */
public class interview {
    public static void main (String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());  //4
        System.out.println(sb);  //"null"
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);  //空指针异常
    }
}