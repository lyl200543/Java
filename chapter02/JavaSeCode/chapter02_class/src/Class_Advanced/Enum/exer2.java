package Class_Advanced.Enum;

/**
 * ClassName: exer2
 * Package: Class_Advanced.Enum
 * Description:创建于 2025/3/28 19:42
 * 案例:颜色枚举类Color(使用enum声明)
 * 声明颜色枚举类:7个常量对象:RED，ORANGE，YELLOW，GREEN，CYAN， BLUE,PURPLE
 * 在测试类中，使用枚举类，获取绿色对象，并打印对象。
 * @Author lyl
 * @Version 1.0
 */
public class exer2 {
    public static void main (String[] args) {
        System.out.println(Color1.GREEN);
    }
}

enum Color1{
    RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE;
}