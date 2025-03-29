package Class_Advanced.Wrapper;

import java.util.Scanner;
import java.util.Vector;

/**
 * ClassName: exer
 * Package: Class_Advanced.Wrapper
 * Description:创建于 2025/3/29 11:35
 * 利用Vector代替数组处理:从键盘读入学生成绩(以负数代表输入结束)，找出最高分，并输出学生成绩等级
 * 提示:数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度
 * 而向量类java.util.Vector可以根据需要动态伸缩
 * 创建Vector对象:Vector v=new Vector();
 * 给向量添加元素:v.addElement(0bject obj);//obj必须是对象
 * 取出向量中的元素:0bject obj=v.elementAt(0);注意第一个元素的下标是0，返回值是0biect类型的
 * 计算向量的长度:v.size();
 * 若与最高分相差10分内:A等;20分内:B等;30分内:C等;其它:D等
 * @Author lyl
 * @Version 1.0
 */
public class exer {
    public static void main (String[] args) {
        Vector v = new Vector();
        Scanner s =new Scanner(System.in);
        int score;
        int max=0;
        System.out.println("请输入学生的成绩：");
        while((score=s.nextInt())>=0){
            if(score>max)
                max=score;
            Integer num=score;
            v.addElement(num);
        }
        s.close();
        System.out.println("最高分为：" + max);

        for (int i = 0 ; i < v.size(); i++) {
            Object obj=v.elementAt(i);
            int grade =(Integer)obj;
            if((max-grade)<=10)
                System.out.println("分数为"+grade+"的学生的成绩等级为：A等");
            else if((max-grade)<=20)
                System.out.println("分数为"+grade+"的学生的成绩等级为：B等");
            else if((max-grade)<=30)
                System.out.println("分数为"+grade+"的学生的成绩等级为：C等");
            else
                System.out.println("分数为"+grade+"的学生的成绩等级为：D等");

        }
    }
}
