# 集合框架

---
## 1.Java集合框架体系(java.util包下) -->都是接口
### java.util.Collection:存储一个一个的数据
#### |-----子接口:List:存储有序的、可重复的数据("动态"数组)
  - |---- ArrayList(主要实现类)、LinkedList、Vector
#### |-----子接口:Set:存储无序的、不可重复的数据(高中学习的集合)
  - |---- HashSet(主要实现类)、LinkedHashSet、TreeSet
### java.util.Map:存储一对一对的数据(key-value键值对,(x1,y1)、(x2,y2)-->y=f(x),类似于高中的函数)
- |---- HashMap(主要实现类)、LinkedHashMap、TreeMap、Hashtable、Properties
---
## 2.Collection中的常用方法:
### 2.1 Collection中定义了15个抽象方法
- add(0bject obj)
- addAll(Collection coll)
- clear():集合中的每个元素赋值为null
- isEmpty()
- size()
- contains(0bject obj):比较的是内容，因此自定义类都需要重写equals()
- containsAll(Collection coll)
- retainAll(Collection coll):(并集)
- remove(0bject obj)
- removeAll(Colleciion coll)
- hashCode()
- equals()
- toArray()
- iterator()
### 2.2 集合与数组的相互转换:
- 集合 --->数组:toArray()
- 数组--->集合:调用Arrays的静态方法asList(0bject ... objs)
### 2.3 向Collection中添加元素的要求:
- 要求元素所属的类一定要重写equals()!
- 原因:因为Collection中的相关方法(比如:contains()/remve())在使用时，要调用元素所在类的equals()
---
## 3.迭代器
### 3.1 迭代器(Iterator)的作用?
- 用来遍历集合元素的
### 3.2 如何获取迭代器(Iterator)对象?
- Iterator iterator =coll.iterator();
### 3.3 如何实现遍历(代码实现)
```java
while(iterator.hasNext()){
        System.out.println(iterator.next());
        //hasNext():指针指向集合第一个元素的前一个位置
        //next():①指针下移 ② 将下移以后集合位置上的元素返回
}
```
### 3.4 增强for循环(foreach循环)的使用(jdk5.0新特性)
#### 3.4.1 作用
- 用来遍历数组、集合。
#### 3.4.2 格式:
- for(要遍历的集合或数组元素的类型 临时变量:要遍历的集合或数组变量){ 操作临时变量的输出}
#### 3.4.3 说明:
- 针对于集合来讲，增强for循环的底层仍然使用的是选代器
- 增强for循环的执行过程中，是将集合或数组中的元素依次赋值给临时变量，注意，循环体中对临时变量的修改
- 可能不会导致原有集合或数组中元素的修改
#### 3.4.4 补充：
- debug状态下，可以使用“Force Step Into” 按钮(快捷键：shift+Alt+Fn+F7)来查看语句底层的源码解释
---
## 4.
