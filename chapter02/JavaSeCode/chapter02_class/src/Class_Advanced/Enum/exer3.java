package Class_Advanced.Enum;

/**
 * ClassName: exer3
 * Package: Class_Advanced.Enum
 * Description:创建于 2025/3/28 19:45
 * 案例拓展:颜色枚举类(使用enum声明)
 * (1)声明颜色枚举类Color:
 * 声明final修饰的int类型的属性red,green,blue
 * 声明final修饰的String类型的属性description
 * 声明有参构造器Color(int red,int green,int blue,String description)
 * 创建7个常量对象:红、橙、黄、绿、青、蓝、紫，重写toString方法
 * 例如:RED(255,0,0)->红色
 * (2)在测试类中，使用枚举类，获取绿色对象，并打印对象
 * 提示:
 * -7个常量对象的RGB值如下:
 * 红:(255,0,0)
 * 橙:(255,128,0)
 * 黄:(255,255,0)
 * 绿:(0,255,0)
 * 青:(0,255,255)
 * 蓝:(0,0,255)
 * 紫:(128,0,255)
 * @Author lyl
 * @Version 1.0
 */
public class exer3 {
    public static void main (String[] args) {
        System.out.println(Color.GREEN);
    }
}

enum Color{
    RED(255,0,0,"红色"),
    ORANGE(255,128,0,"橙色"),
    YELLOW(255,255,0,"黄色"),
    GREEN(0,255,0,"绿色"),
    CYAN(0,255,255,"青色"),
    BLUE(0,0,255,"蓝色"),
    PURPLE(128,0,255,"紫色");

    private final int red;
    private final int green;
    private final int blue;
    private final String description;

    Color (int red , int green , int blue , String description) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.description = description;
    }

    @Override
    public String toString () {
        return this.name()+
                "(" + red +
                "," + green +
                "," + blue +
                ")"+"->"
                +description;
    }
}
