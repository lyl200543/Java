package Class_Advanced.Abstract;

/**
 * ClassName: SalariedEmployee
 * Package: Class_Advanced.Abstract
 * Description:创建于 2025/3/26 9:02
 *
 * @Author lyl
 * @Version 1.0
 */
class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee () {
    }

    public SalariedEmployee (String name , int number , MyDate birthday , double monthlySalary) {
        super(name , number , birthday);
        this.monthlySalary = monthlySalary;
    }

    public double earnings(){
        return monthlySalary;
    }

    public String toString () {
        return "SalariedEmployee[" +
                super.toString() +
                ']';
    }

    public double getMonthlySalary () {
        return monthlySalary;
    }

    public void setMonthlySalary (double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}