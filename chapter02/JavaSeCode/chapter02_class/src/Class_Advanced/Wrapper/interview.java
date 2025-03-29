package Class_Advanced.Wrapper;

/**
 * ClassName: interview
 * Package: Class_Advanced.Wrapper
 * Description:创建于 2025/3/29 20:02
 *
 * @Author lyl
 * @Version 1.0
 */

//自动装箱底层与valueOf有关
//public static Integer valueOf(int i) {
//      if (i >= IntegerCache.low && i <= IntegerCache.high)
//            return IntegerCache.cache[i + (-IntegerCache.low)];
//        return new Integer(i);
//}
//IntegerCache.low=1=-128,IntegerCache.high=127
//说明:如果赋值的值在[-128,+127]范围内，则Integer对象使用的是IntegerCache中数组cache中的元素
//元素已经创建好且只有一份，故元素为1时地址相同，指向同一个Integer类对象
//元素为128时，则需要重新创建一个Integer类对象，地址不同
public class interview {
    public static void main(String[] args) {
        Integer m=1;
        Integer n=1;
        System.out.println(m == n);  //true
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);  //false
        Integer.valueOf(1);

        Boolean b=true;
        Boolean b1=true;
        System.out.println(b==b1);

        Float f=2.2f;
        Float f1=2.2f;
        System.out.println(f==f1);

        Character c = 'w';
        Character c1='w';
        System.out.println(c==c1);
    }
}
