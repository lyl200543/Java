/**
 * ClassName: Exception
 * Package: PACKAGE_NAME
 * Description:创建于 2025/3/20 19:47
 *
 * @Author lyl
 * @Version 1.0
 */
public class Exception
{
    public static void main(String[] args)
    {
        //1.数组越界：ArrayIndexOutOfBoundsException
//        int[] arr=new int[]{1,2,3,4,5};
//        System.out.println(arr[5]);


        //2.空指针异常：NullPointerException
        //1>
//        int[] arr=new int[]{1,2,3};
//        arr=null;
//        System.out.println(arr[0]);

        //2>
//        int[][] arr=new int[3][];
//        System.out.println(arr[1][0]);

        //3>空指针调用方法
        String[] arr=new String[5];
        System.out.println(arr[1].length());

    }

}
