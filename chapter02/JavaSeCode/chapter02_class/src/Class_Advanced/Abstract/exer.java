package Class_Advanced.Abstract;

import java.util.Scanner;

/**
 * ClassName: exer
 * Package: Class_Advanced.Abstract
 * Description:创建于 2025/3/26 8:33
 *
 * @Author lyl
 * @Version 1.0
 */

public class exer {
    public static void main (String[] args) {
        Employee[] e=new Employee[3];
        MyDate d1=new MyDate(2000,5,30);
        e[0]=new SalariedEmployee("张三",1111,d1,10000);

        MyDate d2=new MyDate(2005,4,30);
        e[1]=new HourlyEmployee("李四",1212,d2,500,8);

        MyDate d3=new MyDate(1998,12,1);
        e[2]=new SalariedEmployee("王五",1596,d3,9000);

        System.out.print("请输入本月月份：");
        Scanner sc=new Scanner(System.in);
        int month=sc.nextInt();
        for(int i=0;i<e.length ;i++){
            System.out.println(e[i].toString());
            if(e[i].getBirthday().getMonth()==month){
                System.out.println("本月为该员工生日，工资增加100元");
            }
        }
        sc.close();
    }
}

