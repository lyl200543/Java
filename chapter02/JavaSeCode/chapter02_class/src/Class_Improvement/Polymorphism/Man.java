package Class_Improvement.Polymorphism;

/**
 * ClassName: Man
 * Package: Class_Improvement.Polymorphism
 * Description:创建于 2025/3/23 13:27
 *
 * @Author lyl
 * @Version 1.0
 */
public class Man extends Person{
    private boolean is_smoking;

    public void eat(){
        System.out.println("男人吃饭");
    }

    public void earnmoney(){
        System.out.println("男人赚钱");
    }

    public void toilet(){
        System.out.println("男人上厕所");
    }

    public void smoke(){
        System.out.println("男人抽烟");
    }
}
