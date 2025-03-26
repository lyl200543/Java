package Class_Advanced.Abstract;

/**
 * ClassName: HourlyEmployee
 * Package: Class_Advanced.Abstract
 * Description:创建于 2025/3/26 9:02
 *
 * @Author lyl
 * @Version 1.0
 */
public class HourlyEmployee extends Employee {
    private double wage;
    private int hour;

    public HourlyEmployee () {
    }

    public HourlyEmployee (String name , int number , MyDate birthday , double wage , int hour) {
        super(name , number , birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earnings () {
        return wage*hour;
    }

    public String toString () {
        return "HourlyEmployee[" +
                super.toString()+
                ']';
    }

    public double getWage () {
        return wage;
    }

    public void setWage (double wage) {
        this.wage = wage;
    }

    public int getHour () {
        return hour;
    }

    public void setHour (int hour) {
        this.hour = hour;
    }
}
