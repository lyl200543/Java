/**
 * ClassName: Practice
 * Package: PACKAGE_NAME
 * Description:创建于 2025/3/20 20:46
 *
 * @Author lyl
 * @Version 1.0
 */

//*输入一个整形数组，数组里有正数也有负数。
//数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
//*求所有子数组的和的最大值。要求时间复杂度为0(n)。
//例如:输入的数组为1，-2，3，10，-4，7，2，-5，和最大的子数组为3，10，-4，7，2,因此输出为该子数组的和18。

public class exer1
{
    public static void main(String[] args)
    {
        int[] arr=new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(FindMax(arr));
    }

    public static int FindMax(int[] arr)
    {
        int sum=0;
        int tmp=sum;
        int i;
        for(i=0; i<arr.length; i++)
        {
            tmp+=arr[i];
            if(tmp<0)
                tmp=0;
            if(tmp>sum)
                sum=tmp;
        }
        //处理数组元素全为负数的情况
        if(sum==0)
        {
            sum=arr[0];
            for(i=1;i<arr.length ;i++)
            {
                if(arr[i]>sum)
                    sum=arr[i];
            }
        }
        return sum;
    }
}

