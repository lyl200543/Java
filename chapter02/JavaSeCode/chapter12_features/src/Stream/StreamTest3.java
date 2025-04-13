package Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: StreamTest3
 * Package: Stream
 * Description:创建于 2025/4/13 10:49
 * 终止操作
 *
 * @Author lyl
 * @Version 1.0
 */
public class StreamTest3 {
    //1.匹配与查找
    @Test
    public void test1 () {
        //allMatch(Predicate p)-检查是否匹配所有元素。
        //练习:是否所有的员工的年龄都大于25
        List<Employee> list = EmployeeData.getList();
        System.out.println(list.stream()
                .allMatch(employee -> employee.getAge() > 25));

        //anyMatch(Predicate p)-检查是否至少匹配一个元素
        List<Employee> list1 = EmployeeData.getList();
        System.out.println(list1.stream()
                .anyMatch(employee -> employee.getAge() > 25));

        //findFirst-返回第一个元素
        List<Employee> list2 = EmployeeData.getList();
        System.out.println(list2.stream().findFirst().get());
    }

    @Test
    public void test2 () {
        //count-返回流中元素的总个数
        List<Employee> list = EmployeeData.getList();
        System.out.println(list.stream().count());

        //max(Comparator c)-返回流中最大值
        List<Employee> list1 = EmployeeData.getList();
        System.out.println(list1.stream()
                .max((e1 , e2) -> e1.getAge() - e2.getAge())
                .get());

        //min(Comparator c)-返回流中最小值
        List<Employee> list2 = EmployeeData.getList();
        System.out.println(list2.stream()
                .min((e1 , e2) -> e1.getName().compareTo(e2.getName()))
                .get());

        //forEach(Consumer c)-内部迭代
        //针对于集合，jdk8中增加了一个遍历的方法
        list.forEach(System.out::println);
    }

    //2.归约
    @Test
    public void test3 () {
        //reduce(T identity，BinaryOperator)--可以将流中元素反复结合起来，得到一个值。返回 T
        //练习1:计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10);
//        System.out.println(list.stream()
//                .reduce(0 , (num1 , num2) -> num1 + num2));

        System.out.println(list.stream().reduce(0 , Integer::sum));

        //reduce(Binaryoperator)-可以将流中元素反复结合起来，得到一个值。返回 0ptional<T>
        //练习2:计算公司所有员工年龄的总和
        List<Employee> list1 = EmployeeData.getList();
//        System.out.println(list1.stream()
//                .map(e -> e.getAge())
//                .reduce((age1 , age2) -> age1 + age2)
//                .get());

        System.out.println(list1.stream().map(e -> e.getAge()).reduce(Integer::sum).get());

    }

    //3.收集
    @Test
    public void test4 () {
        List<Employee> list = EmployeeData.getList();
        //Collect(Collector c)-将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习1:查找年龄大于25的员工，结果返回为一个List或Set
        List<Employee> employees = list.stream()
                .filter(employee -> employee.getAge() > 25)
                .collect(Collectors.toList());
        employees.forEach(System.out::println);


        //练习2:按照员工的年龄进行排序，返回到一个新的List中
        List<Employee> employees1 = list.stream()
                .sorted((e1 , e2) -> e1.getAge() - e2.getAge())
                .collect(Collectors.toList());
        employees1.forEach(System.out::println);
    }
}
