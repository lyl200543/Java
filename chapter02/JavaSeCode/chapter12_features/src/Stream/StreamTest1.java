package Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ClassName: StreamTest1
 * Package: Stream
 * Description:创建于 2025/4/13 9:24
 * 测试Stream的实例化
 *
 * @Author lyl
 * @Version 1.0
 */
public class StreamTest1 {
    //创建Stream方式一：通过集合
    @Test
    public void test1 () {
        List<Employee> list = EmployeeData.getList();
        //stream()是Collection中的标准方法
        //default Stream<E>stream():返回一个顺序流
        Stream<Employee> stream = list.stream();

        //default Stream<E> parallelStream():返回一个并行流
        Stream<Employee> parallelStream = list.parallelStream();

    }

    //创建Stream方式二：通过数组
    @Test
    public void test2 () {
        Integer[] arr = new Integer[]{1 , 2 , 3 , 4 , 5};
        Stream<Integer> stream = Arrays.stream(arr);

        int[] arr1 = new int[]{1 , 2 , 3 , 4 , 5};
        IntStream stream1 = Arrays.stream(arr1);
    }

    //创建Stream方式三：通过Stream的of
    @Test
    public void test3 () {
        Stream<String> stream  = Stream.of("aa" , "bb" , "cc");

    }
}
