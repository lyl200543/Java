package exer;

/**
 * ClassName: exer1
 * Package: exer
 * Description:创建于 2025/4/2 19:36s
 *
 * @Author lyl
 * @Version 1.0
 */

//考查:方法参数的值传递机制、String的不可变性
//方法的参数是原来str的副本，两者地址不同，指向的地址相同
//当改变成bad时，副本是由于指向的地址发生了改变导致内容发生了变化
//而原来实参str指向的地址内容没有改变，因此原来str仍然为good
//这一点与c++中常用指针参数不同,传入指针参数时.是可以修改指向地址的内容，因此重新赋值会导致在指向地址上的内容发生变化
//而Java中string不变性是改变副本的地址指向从而改变内容而不是在实参指向地址的内容上覆盖原值
//
public class exer1 {
    String str = "good";
    char[] ch = {'t' , 'e' , 's' , 't'};

    public void exchange (String str , char[] ch) {
        str = "bad";
        ch[0] = 'b';
    }

    public static void main (String[] args) {
        exer1 e = new exer1();
        e.exchange(e.str , e.ch);
        System.out.println(e.str);  //good
        System.out.println(e.ch);   //best

    }
}
