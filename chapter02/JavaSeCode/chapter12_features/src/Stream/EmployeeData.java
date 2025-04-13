package Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: EmployeeData
 * Package: Stream
 * Description:创建于 2025/4/13 9:24
 *
 * @Author lyl
 * @Version 1.0
 */
public class EmployeeData {
    public static List<Employee> getList () {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("zhangsan" , 25));
        list.add(new Employee("wangwu" , 45));
        list.add(new Employee("lyl" , 19));
        list.add(new Employee("lisi" , 30));
        return list;
    }

}
