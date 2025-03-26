package Class_Base;

/**
 * ClassName: Recusion_exer
 * Package: Class_Base
 * Description:创建于 2025/3/22 9:30
 *
 * @Author lyl
 * @Version 1.0
 */

//已知一个数列:f(20)=1,f(21)=4,f(n+2)= 2*f(n+1)+f(n)
//其中n是大于0的整数，求f(10)的值

public class Recusion_exer {
    public static void main (String[] args) {
        Recusion_exer obj=new Recusion_exer();
        System.out.println(obj.func(10));
    }

    public int func(int n){
        if(n==20)
            return 1;
        if(n==21)
            return 4;
        if(n>21) {
            return 2*func(n-1)+func(n-2);
        }
        else{
            return func(n+2)-2*func(n+1);
        }
    }
}
