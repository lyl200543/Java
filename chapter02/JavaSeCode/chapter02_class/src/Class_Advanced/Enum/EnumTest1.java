package Class_Advanced.Enum;

/**
 * ClassName: EnumTest1
 * Package: Class_Advanced.Enum
 * Description:创建于 2025/3/27 15:19
 *
 * @Author lyl
 * @Version 1.0
 */
public class EnumTest1 {
    public static void main (String[] args) {
//        System.out.println(Season1.spring.getClass());
//        System.out.println(Season1.spring.getClass().getSuperclass());
//        System.out.println(Season1.spring.getClass().getSuperclass().getSuperclass());
//        System.out.println(Season1.spring.getClass().getSuperclass().getSuperclass().getSuperclass());

        //测试方法
        //toString()
        System.out.println(Season1.spring.toString());
        System.out.println(Season1.summer);
        //name()
        System.out.println(Season1.winter.name());
        //values()
        Season1[] values=Season1.values();
        for(int i=0;i<values.length;i++){
            System.out.println(values[i]);
        }
        //valuesOf()
        String objname="autumn";
        Season1 obj=Season1.valueOf(objname);
        System.out.println(obj);
        //ordinal()
        System.out.println(Season1.autumn.ordinal());

//        Season1.spring.show();
        Season1[] valuess=Season1.values();
        for(int j=0;j<valuess.length;j++){
            valuess[j].show();
        }
    }

}

interface Info{
    public void show();
}

enum Season1 implements Info{
    //1.必须在枚举类的开头声明多个对象，并且对象之间用逗号隔开
    //情况2：
    spring ("春天","春暖花开"){
        public void show(){
            System.out.println("春天在哪里呀");
        }
    },
    summer ("夏天","夏日炎炎"){
        public void show(){
            System.out.println("夏天夏天悄悄过去");
        }
    },
    autumn ("秋天","秋高气爽"){
        public void show(){
            System.out.println("秋意浓");
        }
    },
    winter ("冬天","白雪皑皑"){
        public void show(){
            System.out.println("而是有你的冬天");
        }
    };

    //2.声明当前类的对象的实例变量，使用private final修饰
    private final String seasonName;
    private final String seasonScr;

    //3.私有化类的构造器
    private Season1(String seasonName ,String seasonScr ){
        this.seasonName =seasonName;
        this.seasonScr =seasonScr;
    }

    public String getSeasonName () {
        return seasonName;
    }

    public String getSeasonScr () {
        return seasonScr;
    }

    @Override
    public String toString () {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonScr='" + seasonScr + '\'' +
                '}';
    }

    //情况1：
//    public void show (){
//        System.out.println("This is a kind of season");
//    }
}
