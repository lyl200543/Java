package Stringexer;

/**
 * ClassName: exer2
 * Package: exer
 * Description:创建于 2025/4/2 19:54
 * 题目1:模拟一个trim方法，去除字符串两端的空格。
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer2 {
    public static String myTrim (String str) {
        char[] ch = str.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while (ch[left] == ' ') {
            left++;
        }
        while (ch[right] == ' ') {
            right--;
        }
        return str.substring(left , right + 1);
    }

    public static void main (String[] args) {
        String s1 = "  he  llo  ";
        String s2 = exer2.myTrim(s1);
        System.out.println(s2);
    }
}

//改进：
class Teacher1 {
    public String myTrim (String str) {
        if (str != null) {
            int start = 0;
            int end = str.length() - 1;
            while (start < end && str.charAt(start) == ' ')
                start++;
            while (start < end && str.charAt(end) == ' ')
                end--;
            if (str.charAt(start) == ' ')
                return "";
            return str.substring(start , end + 1);
        }
        return null;
    }
}