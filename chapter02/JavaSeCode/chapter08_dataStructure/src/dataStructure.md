# 集合的底层数据结构：

---

## 1.List实现类源码分析：

### 1.1 ArrayList

#### 1.1.1 ArrayList的特点:

- 实现了List接口，存储有序的、可以重复的数据
- 底层使用0bject[]数组存储
- 线程不安全

#### 1.1.2 ArrayList源码解析:

##### jdk7版本:(以jdk1.7.0_07为例)

```java
//如下代码的执行:底层会初始化数组，数组的长度为10
//0bject[] elementData= new 0bject[10];
ArrayList<String> list = new ArrayList<>();
list.

add ("AA");  //elementData[0]= "AA".
list.

add ("BB");  //elementData[1]="BB";
//当要添加第11个元素的时候，底层的elementData数组已满，则需要扩容。默认扩容为原来长度的1.5倍。并将原有数组中的元素复制到新的数组中
```

##### jdk8版本:(以jdk1.8.0_271为例)

```java
//如下代码的执行:底层会初始化数组，即:0bject[] elementData= new 0bject[]{};
ArrayList<String> list = new ArrayList<>();
List.

add ("AA");  //首次添加元素时，会初始化数组elementData= new 0biect[10]; elementData[0]="AA";
list.

add ("BB");  //elementData[1]="BB";
//当要添加第11个元素的时候，底层的elementData数组已满，则需要扩容。默认扩容为原来长度的1.5倍。并将原有数组中的元素复制到新的数组中，
```

###### 小结:

- jdk1.7.0_07版本中:ArrayList类似于饿汉式
- jdk1.8.0_271版本中:ArrayList类似于懒汉式

### 1.2 Vector

#### 1.2.1 Vector的特点:

- 实现了List接口，存储有序的、可以重复的数据
- 底层使用0bject[]数组存储
- 线程安全

#### 1.2.2 Vector源码解析:(以jdk1.8.f_271为例)

```java
Vector v = new Vector();  //底层初始化数组，长度为10. 0bject[] elementData= new 0bject[10];
v.

add ("AA");   //elementData[0]= "AA";
v.

add ("BB");   //elementData[1]="BB";
//当添加第11个元素时，需要扩容。默认扩容为原来的2倍
```

### 1.3 LinkedList

#### 1.3.1 LinkedList的特点:

- 实现了List接口，存储有序的、可以重复的数据
- 底层使用双向链表存储
- 线程不安全的

#### 1.3.2 LinkedList在jdk8中的源码解析:

```java
LinkedList<String> list = new LinkedList<>();  //底层也没做啥
List.

add ("AA");   //将"AA"封装到一个Node对象1中，list对象的属性first、last都指向此Node对象1
List.

add ("BB");   //将"BB"封装到一个Node对象2中，对象1和对象2构成一个双向链表，同时last指向此Node对象2
//因为LinkedList使用的是双向链表，不需要考虑扩容问题。
```

##### LinkedList内部声明:

```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;
}
```

##### LinkedList是否存在扩容问题?-->No

### 1.4 启示与开发建议

- 1>Vector基本不使用了
- 2>ArrayList底层使用数组结构
    - 查找和添加(尾部添加)操作效率高，时间复杂度为0(1)
    - 删除和插入操作效率低，时间复杂度为0(n)
- LinkedList底层使用双向链表结构
    - 删除和插入操作效率高，时间复杂度为0(1)
    - 查找和添加(尾部添加)操作效率高，时间复杂度为0(n)(有可能添加操作是0(1))
- 3>在选择了ArrayList的前提下，
    - new ArrayList():底层创建长度为10的数组
    - new ArrayList(int capacity):底层创建指定capacity长度的数组
    - 如果开发中，大体确认数组的长度，则推荐使用ArrayList(int capacity)这个构造器，避免了底层的扩容、复制数组的操作

---

## 2.Map实现类的源码剖析：

### 2.1 HashMap源码解析

#### 2.1.1 jdk7中创建对象和添加数据过程(以JDK1.7.0_07为例说明):

```java
//创建对象的过程中，底层会初始化数组Entry[] table = new Entry[16];
HashMap<String, Integer> map = new HashMap<>();
map.

put ("AA",78);  //"AA"和78封装到一个Entry对象中，考虑将此对象添加到table数组中。
```

##### 添加/修改的过程:

- 将(key1,valve1)添加到当前的map中:
- 首先，需要调用Key1所在类的hashcode()方法，计算key1对应的哈希值1，此哈希值1经过某种算法(hash())之后，得到哈希值2
- 哈希值2再经过某种算法(indexFor())之后，就确定了(key1,value1)在数组table中的索引位置i
    - 1> 如果此索引位置i的数组上没有元素，则(key1,valve1)添加成功 --->情况1
    - 2> 如果此索引位置i的数组上有元素(key2,value2),则需要继续比较key1和key2的哈希值2 --->哈希冲突
        - 2.1> 如果key1的哈希值2与key2的哈希值2不相同，则(key1,valve1)添加成功。---->情况2
        - 2.2> 如果key1的哈希值2与key2的哈希值2相同，则需要继续比较key1和key2的equals()。要调用key1所在类的equals()
          ,将key2作为参数传递进去
    - 3.1> 调用equals()，返回false:则(key1,alve1)添加成功。--->情况3
    - 3.2> 调用equals()，返回true:则认为key1和key2是相同的。默认情况下，valve1替换原有的valve2

###### 说明:

- 情况1:将(key1,value1)存放到数组的索引i的位置
- 情况2,情况3:(key1,value1)元素与现有的(key2,value2)构成单向链表结构,(key1,valve1)指向(key2,valve2)
- 随着不断的添加元素，在满足如下的条件的情况下，会考虑扩容:
- (size >= threshold) && (null != table[i])
- 默认的临界值= 16*0.75 --> 12. 当元素的个数达到临界值(->数组的长度 *加载因子)时，就考虑扩默认扩容为原来的2倍
- 是否扩容是在添加元素时判断的，null != table[i]-->当此时要添加元素的位置table[i]==null时表示改位置没有元素，则暂时不需要扩容
- 因为扩容的原因是不想链表太长，影响后期操作的效率（数组+链表本身不会满）

##### 源码说明：

###### 1>实例化过程

```java
HashMap<String, Integer> map = new HashMap<>();
```

- 对应的源码:

```java
public HashMap () {
    this(DEFAULT_INITIAL_CAPACITY , DEFAULT_LOAD_FACTOR);
}

public HashMap (int initialcapacity , float loadFactor) {
    //...略...
    //通过此循环，得到capacity的最终值，此最终值决定了Entry数组的长度，此时的capacity一定是2的整数倍
    int capacity = 1;
    while (capacity < initialcapacity) {
        capacity <<= 1;
    }
    this.loadFactor = loadFactor;//确定了加载因子的值
    threshold = (int) Math.min(capacity * loadFactor , MAXIMUM_CAPACITY + 1);  //确定了临界值
    table = new Entry[capacity];   //初始化数组，长度为capacity
}
//..略..
```

- 其中:

```java
static final int DEFAULT_INITIAL_CAPACITY = 16;
static final float DEFAULT_LOAD_FACTOR = 0.75f;
final float loadFactor;  //加载因子
int threshold;    //临界值
transient Entry<K, V>[] table;   //存储数组的数组
```

###### 2>put(key,value)的过程

```java
public v put (K key , v value) {
    //HashMap允许添加key为nu11的值。将此(key,value)存放到table索引0的位置
    if (key == nu1l)
        return putForNullKey(value);
    //将key传入hash()，内部使用了key的hashCode()得到哈希值1，然后再经过一个哈希算法，此方法执行结束后，返回哈希值2
    int hash = hash(key);
    //确定当前key，value在数组中的存放位置i
    int i = indexFor(hash , table.length);
    for (Entry<K, V> e = table[i] ; e != null ; e = e.next) {
        object k;
        if (e.hash == hash && ((k = e.key) == key || key.euals(k))) {
            V oldValue = e.value;
            e.value = value;
            e.recordAccess(this);
            return oldValue;  //如果put是修改操作，会返回原有旧的value值。
        }
    }
    addEntry(hash , key , value , i);   //将key,value封装为一个Entry对象，并将此对象保存在索引i位置
    return null;  //如果put是添加操作，会返回null
}
```

- 其中：

```java
final int hash (object k) {
    int h = 0;
    if (useAltHashing) {
        if (k instanceof string) {
            return sun.misc.Hashing.stringHash32((string) k);
        }
        h = hashSeed;
    }
    h ^= k.hashCode();  //使用了hashCode()
// This function ensures that hashcodes .that differ only by
// constant multiples at each bit position have d bounded
// number of collisions(approximately 8 at default load factor).
    h ^= (h >>> 28) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
}
```

```java
  static int indexFor (int h , int length) {
    return h & (length - 1);
    //说明：假设h=1234,length=16,则在二进制下，h=...010011010010  ,length-1=...1111(省略的全是0)
    //h & (length - 1)=...0010(省略的全是0),h为任何数时，&后的范围都在[0,length-1],比取模效率更高
    //这也是为什么一定要保证capcity为2的n次方
}
```

```java
void addEntry (int hash , K key , V value , int bucketIndex) {
    if ((size >= threshold) && (null != table[bucketIndex])) {   //扩容的条件
        resize(2 * table.length);   //默认扩容为原有容量的2倍
        hash = (null != key) ? hash(key) : 0;
        bucketIndex = indexFor(hash , table.length);
    }
    createEntry(hash , key , value , bucketIndex);

}
```

```java
void createEntry (int hash , K key , V value , int bucketIndex) {
    Entry<K, V> e = table[bucketIndex];
    table[bucketIndex] = new Entry<>(hash , key , value , e);
    //头插法：原本的e作为新的Entry的next
    size++;
}
 ```
##### 3>Entry的定义如下
```java
static class Entry<K,V> implements Map.Entry<K,V> {
    final K key;
    V value;
    Entry<K, V> next;
    int hash;

    /**
     * Creates new entry.
     */
    Entry (int h , K k , V v , Entry<K, v> n) {
        value = v;
        next = n;
        key = k;
        hash = h;
    }
}
 ```
