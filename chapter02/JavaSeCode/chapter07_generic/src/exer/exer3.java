package exer;

import java.util.*;

/**
 * ClassName: exer3
 * Package: exer
 * Description:创建于 2025/4/6 18:54
 * 定义个泛型类 DA0<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 * 分别创建以下方法:
 * public void save(String id,T entity): 保存 丅 类型的对象到 Map 成员变量中
 * public T get(String id):从 map 中获取 id 对应的对象
 * public void update(String id,T entity):替换 map 中key为id的内容,改为 entity 对象
 * public List<T>list():返回 map 中存放的所有 T 对象
 * public void delete(String id):删除指定 id 对象
 *
 * @Author lyl
 * @Version 1.0
 */
public interface exer3 {

}

class DAO<T> {
    private Map<String, T> map;

    public void save (String id , T entity) {

        if (! map.containsKey(id)) {
            map.put(id , entity);
        }
    }

    public T get (String id) {
        return map.get(id);
    }

    public void update (String id , T entity) {
        if (map.containsKey(id)) {
            map.put(id , entity);
        }
    }

    public List<T> list () {
        //错误做法：
//        List<T> values = (List<T>) map.values();
//        return values;

        //正确做法1:
//        ArrayList<T> arr = new ArrayList<>();
//        Collection<T> values = map.values();
//        arr.addAll(values);

        //正确做法2:
        Collection<T> values = map.values();
        ArrayList<T> arr = new ArrayList<>(values);
        return arr;
    }

    public void delete (String id) {
        map.remove(id);
    }

}
