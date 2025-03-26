package Class_Improvement.Polymorphism;

/**
 * ClassName: Woman
 * Package: Class_Improvement.Polymorphism
 * Description:创建于 2025/3/23 13:29
 *
 * @Author lyl
 * @Version 1.0
 */
public class Woman extends Person{
    private boolean is_tall;

    public void eat(){
        System.out.println("女人吃饭");
    }

    public void earnmoner(){
        System.out.println("大女人赚钱");
    }

    public void toilet(){
        System.out.println("女人上厕所");
    }

    public void makeup(){
        System.out.println("女人化妆");
    }
}
