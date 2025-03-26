package Class_Base;

/**
 * ClassName: LengthVariableArgument
 * Package: Class_Base
 * Description:创建于 2025/3/21 20:05
 *
 * @Author lyl
 * @Version 1.0
 */

//可变个数形参：[数据类型] ... [变量名] --> 代替数组形参
//含可变个数形参的函数可以有重载函数,优先调用形参个数确定的重载函数
//可变个数形参一定要放在参数列表最后一个
//一个方法中只能有一个可变个数形参

public class Length_Variable_Argument {
    public static void main (String[] args) {
        Length_Variable_Argument obj = new Length_Variable_Argument();
        obj.Print();
        obj.Print(1);
        obj.Print(1 , 2);
        //public void Print(int[] nums)的传参方法
        //obj.Print(new int[]{1,2,3});
    }

    public void Print (int... nums) {
        System.out.println("1111");
    }

    //int ... nums 相当于 int[] nums，不能重载
//    public void Print(int[] nums){
//        System.out.println("1111");
//    }


    //重载函数
//    public void Print(int a){
//        System.out.println("1111");
//    }
//
//    public void Print(int a, int b){
//        System.out.println("1111");
//    }


    //可变个数形参必须放在最后一个
//    public void Print(int i, int ... nums){
//        System.out.println("1111");
//    }

}
