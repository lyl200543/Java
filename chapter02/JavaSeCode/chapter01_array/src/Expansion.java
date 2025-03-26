/**
 * ClassName: Expansion
 * Package: PACKAGE_NAME
 * Description:创建于 2025/3/20 16:33
 *
 * @Author lyl
 * @Version 1.0
 */
public class Expansion
{
    public static void main(String[] args)
    {
        int[] arr=new int[]{1,2,3,4,5};
        //在Java里，内存管理依靠垃圾回收机制（Garbage Collection，GC）自动完成

        //int[]newArr=new int[arr.length *2];
        int[] newArray=new int[arr.length <<1];

        int i;
        for(i=0; i<arr.length; i++)
        {
            newArray[i]=arr[i];
        }
        newArray[arr.length ]=6;
        newArray[arr.length +1]=7;
        newArray[arr.length +2]=8;
        //没有初始化系统会自动初始化为0
        for(i=0; i<newArray.length ;i++)
        {
            System.out.print(newArray[i]+"\t");
        }

    }

}
