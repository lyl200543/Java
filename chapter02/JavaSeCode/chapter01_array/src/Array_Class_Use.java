/**
 * ClassName: Array_Class_Use
 * Package: PACKAGE_NAME
 * Description:创建于 2025/3/20 18:58
 *
 * @Author lyl
 * @Version 1.0
 */
public class Array_Class_Use
{
    public static void main(String[] args)
    {
        //1.static boolean equals(int[] a, int[] a2)
        //如果两个指定的整数数组彼此相等，则返回true。
        //直接arr==arr2比较的是地址
//        int[] arr=new int[]{1,2,3,4,5};
//        int[] arr2=new int[]{1,2,3,4,4};
//        boolean ret= Arrays.equals(arr,arr2);
//        System.out.println(ret);


        //2.static String toString(int[] a)
        //返回指定数组内容的字符串表示形式。
//        int[] arr=new int[]{1,2,3,4,5};
//        System.out.println(arr);  //[I@b4c966a
//        System.out.println(Arrays.toString(arr));  //[1, 2, 3, 4, 5]


        //3.static void fill(int[] a, int val)
        //将指定的整数值分配给指定整数数组的每个元素。
//        int[] arr = new int[]{1,2,3,4,5};
//        Arrays.fill(arr,6);
//        System.out.println(Arrays.toString(arr));


        //4.static void sort(int[] a)
        //将指定的数组按升序数字顺序排序。
        //使用的排序方法是快速排序。
//        int[] arr=new int[]{45,78,25,16,96,31,5};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));



        //5.static int binarySearch(int[] a, int key)
        //使用二分搜索算法在指定整数数组中搜索指定值。
        //如果指定值存在，则返回该指定值的索引
        //注意：数组必须有序
//        int[] arr=new int[]{5, 16, 25, 31, 45, 78, 96};
//        int ret=Arrays.binarySearch(arr,15);
//        if(ret>=0)
//        {
//            System.out.println("找到该值，在数组中的索引为："+ret);
//        }
//        else
//            System.out.println("找不到该值");
    }
}
