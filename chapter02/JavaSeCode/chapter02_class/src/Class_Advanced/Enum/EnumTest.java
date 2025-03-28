package Class_Advanced.Enum;

/**
 * ClassName: EnumTest
 * Package: Class_Advanced.Enum
 * Description:创建于 2025/3/27 14:45
 *
 * @Author lyl
 * @Version 1.0
 */
public class EnumTest {
    public static void main (String[] args) {
        System.out.println(Season.spring);
        System.out.println(Season.summer.getSeasonName());
        System.out.println(Season.summer.getSeasonScr());
    }
}


//jdk5.0之前定义枚举类的方法：
class Season{
    private final String seasonName;
    private final String seasonScr;

    private Season(String seasonName ,String seasonScr ){
        this.seasonName =seasonName;
        this.seasonScr =seasonScr;
    }

    public String getSeasonName () {
        return seasonName;
    }

    public String getSeasonScr () {
        return seasonScr;
    }

    public static final Season spring =new Season("春天","春暖花开");
    public static final Season summer =new Season("夏天","夏日炎炎");
    public static final Season autumn =new Season("秋天","秋高气爽");
    public static final Season winter =new Season("冬天","白雪皑皑");

    @Override
    public String toString () {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonScr='" + seasonScr + '\'' +
                '}';
    }
}
