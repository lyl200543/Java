package exer;

import java.util.*;

/**
 * ClassName: exer.exer
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/5 21:36
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer {
    public static void main (String[] args) {
        Map map = CityMap.model;
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t\t");
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择你所在的省份:");
        String[] values;
        while (true) {
            String province = scanner.next();
            Object value = map.get(province);
            if (value != null) {
                values = (String[]) value;
                for (int i = 0 ; i < values.length ; i++) {
                    System.out.print(values[i] + "\t\t");
                }
                break;
            }
            System.out.println("输入省份错误，请重新输入");
        }
        System.out.println("\n请选择你所在的城市：");
        //标签的用法：在 Java 里，标签（label）是一种标识符，它后面跟着一个冒号 :
        //主要用于嵌套循环或者嵌套代码块，借助标签能够实现从内层循环或代码块跳转到外层循环或代码块
        l:while (true) {
            String city = scanner.next();
            for (int i = 0 ; i < values.length ; i++) {
                if(values [i].equals(city) ){
                    System.out.println("信息登记完毕");
                    break l;
                }
            }
            System.out.println("输入城市错误，请重新输入");
        }
        scanner.close();
    }
}

class CityMap {
    public static Map model = new HashMap();

    static {
        model.put("北京" , new String[]{"北京"});
        model.put("辽宁" , new String[]{"沈阳" , "盘锦" , "铁岭" , "丹东" , "大连" , "锦州" , "营口"});
        model.put("吉林" , new String[]{"长春" , "延边" , "吉林" , "白山" , "白城" , "四平" , "松原"});
        model.put("河北" , new String[]{"承德" , "沧州" , "邯郸" , "邢台" , "唐山" , "保定" , "石家庄"});
        model.put("河南" , new String[]{"郑州" , "许昌" , "开封" , "洛阳" , "商丘" , "南阳" , "新多"});
        model.put("山东" , new String[]{"济南" , "青岛" , "日照" , "临沂" , "泰安" , "聊城" , "德州"});
    }


}