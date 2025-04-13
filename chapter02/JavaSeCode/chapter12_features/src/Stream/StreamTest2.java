package Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * ClassName: StreamTest2
 * Package: Stream
 * Description:创建于 2025/4/13 9:42
 * 中间操作
 *
 * @Author lyl
 * @Version 1.0
 */
public class StreamTest2 {
    //1.筛选与切片
    @Test
    public void test1 () {
        //filter(Predicate p)-接收 Lambda，从流中排除某些元素。
        // 练习:查询员工表中年龄大于25的员工信息
        List<Employee> list = EmployeeData.getList();
        Stream<Employee> stream = list.stream();
        //中间操作，没出现终止操作之前不会生效
        //stream.filter(employee -> employee.getAge() > 25);

        //forEach()是终止操作
        stream.filter(employee -> employee.getAge() > 25).forEach(System.out::println);
    }

    @Test
    public void test2 () {
        //limit(n)-截断流，使其元素不超过给定数量。
        List<Employee> list = EmployeeData.getList();
        Stream<Employee> stream = list.stream();
        //stream.limit(2).forEach(System.out::println);
        //一旦进行了终止操作，就不能再进行其他操作
        //链式调用
        stream.filter(employee -> employee.getAge() > 25).limit(1).forEach(System.out::println);
    }

    @Test
    public void test3 () {
        //skip(n)- 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit互补
        List<Employee> list = EmployeeData.getList();
        Stream<Employee> stream = list.stream();
        stream.skip(2).forEach(System.out::println);


    }

    @Test
    public void test4 () {
        //distinct()-筛造,通过流所生成元素的 hashCode()和 equals()去除重复元素
        List<Employee> list = EmployeeData.getList();
        Stream<Employee> stream = list.stream();
        list.add(new Employee("xiaoming" , 12));
        list.add(new Employee("xiaoming" , 12));
        list.add(new Employee("xiaoming" , 12));
        list.add(new Employee("xiaoming" , 12));
//        System.out.println(list);
        stream.distinct().forEach(System.out::println);
    }

    //2.映射
    @Test
    public void test5 () {
        //map(Function f)-接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素
        //练习:转换为大写
        List<String> list = Arrays.asList("aa" , "bb" , "cc");
        Stream<String> stream = list.stream();
        //stream.map(s1 -> s1.toUpperCase()).forEach(System.out::println);
        stream.map(String::toUpperCase).forEach(System.out::println);

        //练习:获取员工姓名长度大于3的员工的姓名。
        List<Employee> list1 = EmployeeData.getList();
        Stream<Employee> stream1 = list1.stream();
        //stream1.map(employee -> employee.getName()).filter(s -> s.length() > 3).forEach(System.out::println);
        stream1.map(Employee::getName).filter(s -> s.length() > 3).forEach(System.out::println);
    }

    //3.排序
    @Test
    public void test6 () {
        //sorted()-自然排序
        Integer[] arr = new Integer[]{345 , 3 , 64 , 3 , 46 , 7 , 3 , 34 , 65 , 68};
        String[] arr1 = new String[]{"GG" , "DD" , "MM" , "SS" , "JJ"};

        Arrays.stream(arr).sorted().forEach(System.out::println);
        Arrays.stream(arr1).sorted().forEach(System.out::println);


        //sorted(Comparator com)--定制排序
        List<Employee> list = EmployeeData.getList();
        list.stream()
                .sorted((e1 , e2) -> e1.getAge() - e2.getAge())
                .forEach(System.out::println);

        Arrays.stream(arr1)
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

}
