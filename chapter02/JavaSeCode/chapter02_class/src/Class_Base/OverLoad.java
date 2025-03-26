package Class_Base;

/**
 * ClassName: OverLoad
 * Package: Class_Base
 * Description:创建于 2025/3/21 19:19
 *
 * @Author lyl
 * @Version 1.0
 */
public class OverLoad {
    public static void main(String[] args){
        int[] arr1=new int[]{1,2,3};
        System.out.println(arr1);  //[I@b4c966a

        //public void println(char[] x)  特殊：会打印字符数组的值
        char[] arr2=new char[]{'a','b','c'};
        System.out.println(arr2);  //abc

        boolean[] arr3=new boolean[]{true,false,false};
        System.out.println(arr3);   //[Z@2f4d3709
    }

}
