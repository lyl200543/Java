package Stringexer;

/**
 * ClassName: exer3
 * Package: exer
 * Description:创建于 2025/4/2 19:55
 * 题目2:将一个字符串进行反转。将字符串中指定部分进行反转比如"abcdefg"反转为"abfedcg'
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer3 {
    public static String transString (String str , int start , int end) {
        char[] ch = str.toCharArray();
        while (start < end) {
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
        return new String(ch);
    }

    public static void main (String[] args) {
        String s1 = "abcdefg";
        System.out.println(exer3.transString(s1 , 2 , 5));
    }

}

//拼接版本：
class Teacher2 {

    public String reverse (String str , int start , int end) {
        //第一部分
        String finalstr = str.substring(0 , start);

        //第二部分
        for (int i = end ; i <= start ; i--) {
            finalstr += str.charAt(i);
        }
        //第三部分
        finalstr += str.substring(end + 1);

        return finalstr;
    }
}
