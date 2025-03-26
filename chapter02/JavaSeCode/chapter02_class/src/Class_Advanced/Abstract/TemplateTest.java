package Class_Advanced.Abstract;

/**
 * ClassName: TemplateTest
 * Package: Class_Advanced.Abstract
 * Description:创建于 2025/3/25 20:56
 *
 * @Author lyl
 * @Version 1.0
 */
public class TemplateTest {
    public static void main (String[] args) {
        PrintPrimeNumber test=new PrintPrimeNumber();
        test.spendTime();
    }
}

abstract class Template{
    public void spendTime(){
        long start=System.currentTimeMillis();
        Code();
        long end=System.currentTimeMillis();
        System.out.println("花费时间为："+(end-start));
    }
    public abstract void Code();
}

class PrintPrimeNumber extends Template{
    @Override
    public void Code () {
        for(int i=2;i<=10000;i++){
            boolean flag=true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println(i);
            }
        }
    }
}