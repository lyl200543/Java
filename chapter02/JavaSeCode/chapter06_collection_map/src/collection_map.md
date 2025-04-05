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
- retainAll(Collection coll):(交集)
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
## 4.List接口和实现类的使用：
### 4.1 List接口中存储数据的特点:
- 用于存储有序的、可以重复的数据 ---> 使用List替代数组，"动态"数组
### 4.2 List中的常用方法:
#### 第1波:Collection中声明的15个方法
#### 第2波:因为List是有序的，进而就有索引，进而就会增加一些针对索引操作的方法
##### 插入元素
- void add(int index，0bject ele):在index位置插入ele元素
- boolean addAll(int index，Collection eles):从index位置开始将eles中的所有元素添加进来
##### 获取元素
- 0bject get(int index):获取指定index位置的元素
- List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集合
##### 获取元素索引
- int index0f(0bject obj):返回obj在集合中首次出现的位置
- int lastIndex0f(0bject obj):返回obj在当前集合中末次出现的位置
##### 删除和替换元素
- 0bject remove(int index):移除指定index位置的元素，并返回此元素
- 0bject set(int index，0bject ele):设置指定index位置的元素为ele
### 4.3 小结
#### 增
- add(0bject obj)
- addAll(Collection coll)
#### 删
- remove(0bject obj)
- remove(int index)
#### 改
- set(int index,0bject ele)
#### 查
- get(int index)
#### 插
- add(int index,0bject ele)
- addAll(int index,Collection eles)
#### 长度
- size()
#### 遍历
- 使用迭代器进行遍历iterator()
- 增强for循环
- 普通for循环
### 4.4 List及其实现类特点
#### java.util.Collection:存储一个一个的数据
#####    |-----子接口:List:存储有序的、可重复的数据("动态"数组)
######        |------------ ArrayList:List的主要实现类;线程不安全的、效率高;底层使用0bject[]数组存储
- 在添加数据、查找数据时，效率较高;在插入、删除数据时，效率较低
######        |------------ LinkedList:底层使用`双向链表`的方式进行存储
- 在插入、删除数据时，效率较高;在添加数据、查找数据时，效率较低
- 在对集合中的数据进行频繁的删除、插入操作时，建议使用此类
######        |------------ Vector:List的古老实现类;线程安全的、效率低;底层使用0bject[]数组存储

---
## 5.Set接口及其实现类的使用
### 5.1 Set及其实现类特点：
#### java.util.Collection:存储一个一个的数据
##### |-----子接口:Set:存储无序的、不可重复的数据(高中学习的集合)
###### |--------- HashSet:主要实现类;底层使用的是HashMap，即使用数组+单向链表+红黑树结构进行存储。(jdk8中)(遍历顺序与添加顺序不一致)
###### |-------------------- LinkedHashSet:是HashSet的子类;在现有的数组+单向链表+红黑树结构的基础上(遍历顺序与添加顺序一致)
###### 又添加了一组双向链表，用于记录添加元素的先后顺序。即:我们可以按照添加元素的顺序实现遍历。便于频繁的查询操作。
###### |-------- TreeSet:底层使用红黑树存储，可以按照添加的元素的指定的属性的大小顺序进行遍历
### 5.2 开发中的使用频率及场景:
- 较List、Map来说，Set使用的频率比较少
- 用来过滤重复数据 
### 5.3 Set中常用方法:
- 即为Collection中声明的15个抽象方法，没有新增的方法
### 5.4 Set中无序性、不可重复性的理解(以HashSet及其子类为例说明)
#### 无序性：
- 无序性:!= 随机性
- 添加元素的顺序和遍历元素的顺序不一致,是不是就是无序性呢? No!
- 到底什么是无序性?与添加的元素的位置有关，不像ArrayList一样是依次紧密排列的
- ***这里是根据添加的元素的哈希值，计算的其在数组中的存储位置，此位置不是依次排列的，表现为无序性***
#### 不可重复性：
- 不可重复性:添加到Set中的元素是不能相同的
- 比较的标准，需要判断hashcode()得到的哈希值以及equals()得到的boolean型的结果
- 哈希值相同且equals()返回true，则认为元素是相同的
#### 添加到HashSet/LinkedHashset中元素的要求:
- 要求元素所在的类要重写两个方法:equals()和hashCode()
- 同时，要求equals()和 hashcode()要保持一致性!我们只需要在IDEA中自动生成两个方法的重写即可，即能保证两个方法的一致性
### 5.5 Treeset的使用
#### 底层的数据结构:红黑树
- 添加数据后的特点:可以按照添加的元素的指定的属性的大小顺序进行遍历
#### 向Treeset中添加的元素的要求:
- 要求添加到TreeSet中的元素必须是同一个类型的对象，否则会报ClassCastException
- 添加的元素需要考虑排序:①自然排序 ② 定制排序
#### 判断数据是否相同的标准
- 不再是考虑hashcode()和equals()方法了，也就意味着添加到Treeset中的元素所在的类不需要重写hashcode()和equals()
- 比较元素大小的或比较元素是否相等的标准就是考虑自然排序或定制排序中，compareTo()或compare()的返回值
- 如果compareTo()或compare()的返回值为0，则认为两个对象是相等的
- 由于Treeset中不能存放相同的元素，则后一个相等的元素就不能添加到Treeset中
---
## 6.Map接口及其实现类的使用
### 6.1 Map及其实现类对比
#### java.util.Map:存储一对一对的数据(key-value键值对，(x1,y)、(x2,y2)--> y=f(x),类似于高中的函数)
##### |----HashMap:主要实现类;线程不安全的，效率高;可以添加null的key和valve值;底层使用数组+单向链表+红黑树结构存储(jdk8)
##### |--------------LinkedHashMap:是HashMap的子类;在HashMap使用的数据结构的基础上，增加了一对双向链表
- 用于记录添加的元素的先后顺序，进而我们在遍历元素时，就可以按照添加的顺序显示
- 开发中，对于频繁的遍历操作,建议使用此类
##### |----TreeMap:底层使用红黑树存储;可以按照添加的key-vlue中的key元素的指定的属性的大小顺序进行遍历,需要考虑使用①自然排序 ②定制排序
##### |---- Hashtable:古老实现类;线程安全的，效率低;不可以添加null的key或valve值;底层使用数组+单向链表结构存储
##### |-------------- Properties:是Hashtable的子类，其key和value都是String类型,常用来处理属性文件
### 6.2 HashMap中元素的特点
- HashMap中的所有的Key彼此之间是不可重复的、无序的。所有的key就构成一个Set集合。--->key所在的类要重写hashcode()和equals()
- HashMap中的所有的value彼此之间是可重复的、无序的。所有的valve就构成一个Collection集合。--->value所在的类要重写equals()
- HashMap中的一个key-value,就构成了一个entry。HashMap中的所有的entry彼此之间是不可重复的、无序的。所有的entry就构成了一个Set集合
### 6.3 Map中的常用方法
#### 添加、修改操作:
- 0bject put(0bject key,0bject valve):将指定key-value添加到(或修改)当前map对象中
- void putAll(Map m):将m中的所有key-valve对存放到当前map中
#### 删除操作:
- 0bject remove(0bject key):移除指定key的key-value对，并返回value
- void clear():清空当前map中的所有数据元素
#### 查询的操作:
- 0bject get(0bject key):获取指定key对应的value
- boolean containsKey(0bject key):是否包含指定的key
- boolean containsValve(0bject valve):是否包含指定的valve
- int size():返回map中key-value对的个数
- boolean isEmpty():判断当前map是否为空
- boolean equals(0bject obj):判断当前map和参数对象obj是否相等
#### 元视图操作的方法:
- Set keySet():返回所有key构成的Set集合
- Collection valves():返回所有valve构成的Collection集合
- Set entrySet():返回所有key-value对构成的Set集合
#### 小结
##### 增:
- put(0bject key,0bject value)
- putALl(Map m)
##### 删:
- 0bject remove(0bject key)
##### 改:
- put(0bject key,0bject value)
- putALL(Map m)
##### 查:
- 0bject get(object key)
##### 长度:
size()
##### 遍历:
- 遍历key集:Set keySet()
- 遍历value集:Collection values()
- 遍历entry集:Set entrySet()
### 6.4 TreeMap的使用
- 底层使用红黑树存储;
- 可以按照添加的key-value中的`key元素`的指定的属性的大小顺序进行遍历
- 需要考虑使用①自然排序 ②定制排序
- 要求:向TreeMap中添加的key必须是同一个类型的对象
### 6.5 Hashtable与Properties的使用
- Properties:是Hashtable的子类，其key和valve都是String类型的，常用来处理属性文件
---
## 7.