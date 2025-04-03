# String

---
## 1.String类的理解(以JDK8为例说明)
### 1.1 类的声明
```java
public final class String
        implements java.io.Serializable, Comparable<String>, CharSequence {
    
}
```
- final:String是不可被继承的
- Serializable:可序列化的接口,凡是实现此接口的类的对象就可以通过网络或本地流进行数据的传输
- Comparable:凡是实现此接口的类，其对象都可以比较大小
### 1.2 内部声明的属性:
#### jdk8中: 
- private final char valve[];  //存储字符串数据的容器
- final :指明此valve数组一旦初始化，其地址就不可变
#### jdk9开始:为了节省内存空间，做了优化
- private final byte[] valve;  //存储字符串数据的容器
---
## 2.字符串常量的存储位置
- 字符串常量都存储在字符串常量池(StringTable)中
- 字符串常量池不允许存放两个相同的字符串常量
- 字符串常量池，在不同的jdk版本中，存放位置不同
  - jdk7之前:字符串常量池存放在`方法区`
  - jdk7及之后:字符串常量池存放在`堆空间`
---
## 3.String的不可变性的理解
- ①当对字符串变量重新赋值时，需要重新指定一个字符串常量的位置进行赋值，不能在原有的位置修改
- ②当对现有的字符串进行拼接操作时，需要重新开辟空间（堆空间）保存拼接以后的字符串，不能在原有的位置修改
- ③当调用字符串的replace()替换现有的某个字符时，需要重新开辟空间（堆空间）保存修改以后的字符串，不能在原有的位置修改
---
## 4.String实例化的两种方式：
- 第1种方式:String s1="hello";
- 第2种方式:String s2=new String("hello");
```java 
//【面试题】
String s2 = new string("hello");  //在内存中创建了几个对象?

//创建了两个对象，一个是在堆空间的s2,一个是在字符串常量池的“hello”,s2指向"hello"
```
---
## 5.String的连接操作:+
- 情况1:`常量 + 常量`:结果仍然存储在字符串常量池中，返回此字面量的地址(注:此时的常量可能是字面量，也可能是final修饰的变量)
- 情况2:`常量 +变量 或 变量 + 变量`:都会通过new的方式创建一个新的字符串，返回堆空间中此字符串对象的地址
- 情况3:字符串变量调用字符串的intern():返回的是字符串常量池中字面量的地址
- (了解)情况4:concat(xxx):作用是追加字符串
- 不管是常量调用此方法，还是变量调用，同样不管参数是常量还是变量,总之，调用完concat()方法都返回一个新new的对象
---
## 6.构造器
- public string():初始化新创建的String对象，以使其表示空字符序列
- String(string original): 初始化一个新创建的string对象，使其表示一个与参数相同的字符序列;换句话说，新创建的字符串是该参数字符串的副本
- public string(char[] value):通过当前参数中的字符数组来构造新的String
- public String(char[]value,int offset，int count):通过字符数组的一部分来构造新的string
- public string(byte[] bytes):通过使用平台的默认字符集解码当前参数中的字节数组来构造新的String
- public string(byte[]bytes,string charsetName):通过使用指定的字符集解码当前参数中的字节数组来构造新的String
---
## 7.常用方法：
- (1)boolean isEmpty():字符串是否为空
- ***(2)int length():返回字符串的长度***
- (3)String concat(xx):拼接
- (4)boolean equals(0bject obj):比较字符串是否相等，区分大小写
- (5)boolean equalsIgnoreCase(0bject obj):比较字符串是否相等，不区分大小写
- (6)int compareTo(string other):比较字符串大小，区分大小写，按照Unicode编码值比较大小
- (7)int compareToIgnorecase(String other):比较字符串大小，不区分大小写
- (8)String toLowerCase():将字符串中大写字母转为小写
- (9)String toUpperCase():将字符串中小写字母转为大写
- (10)String trim():去掉字符串前后空白符
- (11)public String intern():结果在常量池中共享
- (12)boolean contains(xx):是否包含xx
- ***(13)int indexof(xx):从前往后找当前字符串中xx，即如果有返回第一次出现的下标，要是没有返回-1***
- (14)int indexOf(string str,int fromlndex):返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
- (15)int lastindexof(xx):从后往前找当前字符串中xx，即如果有返回最后一次出现的下标，要是没有返回-1
- (16)int lastlndexof(string str,int fromlndex):返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
- (17)String substring(int beginindex):返回一个新的字符串，它是此字符串的从beginlndex开始截取到最后的- 个子字符串
- (18)String substring(int beginIndex,int endindex):返回一个新字符串，它是此字符串从beginlndex开始截取到endIndex(不包含)的一个子字符串
- (19)char[] tocharArray():将此字符串转换为一个新的字符数组返回
- (20)static String value0f(char data):返回指定数组中表示该字符序列的 String
- (21)static String valueOf(charll data, int offset, int count): 返回指定数组中表示该字符序列的 String
- (22)static string copyalueOf(charl] data): 返回指定数组中表示该字符序列的 String
- (23)static String copyValueOf(charll data, int offset,int count):返回指定数组中表示该字符序列的 string
- ***(24)char charAt(index):返回[index]位置的字符***
- (25)boolean startswith(xx):测试此字符串是否以指定的前缀开始
- (26)boolean startswith(string prefix,int toffset):测试此字符串从指定索引开始的子字符串是否以指定前缀开始
- (27)boolean endswith(xx):测试此字符串是否以指定的后缀结束
- (28)String replace(char oldchar, charnewchar):返回一个新的字符串，它是通过用 newchar 替换此字符串中出现的所有 oldchar 得到的，不支持正则
- (29)String replace(charSequence target, charSequence replacement):使用指定的字面值替换序列，替换此字符串所有匹配字面值目标序列的子字符串
- (30)stringreplaceAl(String regex,String replacement):使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串
- (31)String replaceFirst(String regex, String replacement):使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串
---
## 8.StringBuffer,StringBuilder:
### 8.1 三个类的对比:String、StringBuffer、StringBuilder
- String:不可变的字符序列;底层使用char[](jdk8及之前)，底层使用byte[](jdk9及之后)
- StringBuffer:可变的字符序列;JDK1.0声明，线程安全的，效率低;底层使用char[] (idk8及之前)，底层使用byte[](jdk9及之后)
- StringBuilder:可变的字符序列;JDK5.0声明，线程不安全的,效率高;底层使用char[] (idk8及之前)，底层使用byte[](jdk9及之后)
### 8.2 StringBuffer/StringBuilder的可变性分析(源码分析):
```java
String s1 = new String();  //char[] value = new char[0];
String s2 = new String("abc");  // char[] value = new char[]{'a','b','c'};
```
- 针对于StrinqBuilder来说:
- 内部的属性有:
- char[] value;  //存储字符序列
- int count;  //实际存储的字符的个数
```java
StringBuilder sBuffer1 = new StringBuilder();
//char[] value = new char[16];
StringBuilder sBuffer2 = new stringBuilder("abc"); 
//char[] value = new char[16 + "abc".length];
sBuffer1.append("ac");  //value[0]='a'; value[1]='c';
sBuffer1.append("b");   //value[2]='b';
```
- 字符串的初始容量为16
- 不断的添加，一旦count要超过value.length时，就需要扩容:***默认扩容为原有容量的2倍+2***
- 并将原有valve数组中的元素复制到新的数组中
- 如果默认扩容容量小于增加的字符个数时，则扩容至要增加的字符个数
### 8.3 String类的选择：
- ①如果开发中需要频繁的针对于字符串进行增、删、改等操作，建议使用StringBuffer或stringBuilder替换String，因为使用Strinq效率低
- ②如果开发中，不涉及到线程安全问题，建议使用StringBuilder替换StringBuffer。因为使用StringBuilder效率高
- ③如果开发中大体确定要操作的字符的个数，建议使用带int capacitv参数的构造器，因为可以避免底层多次扩容操作，性能降低
### 8.4 常用方法：
- (1)StringBuffer append(xx):提供了很多的append()方法，用于进行字符串追加的方式拼接
- (2)StringBuffer delete(int start, int end): 删除[start,end)之间字符
- (3)StringBuffer deletecharAt(int index):删除[index]位置字符
- (4)StringBuffer replace(int start, int end, String str):替换[start,end)范围的字符序列为str
- (5)void setcharAt(int index, char c):替换[index]位置字符
- (6)char charAt(int index):查找指定index位置上的字符
- (7)***StringBuffer insert(int index,xx):在[index]位置插入xx***
- (8)int length():返回存储的字符数据的长度
- (9)***StringBuffer reverse():反转***
- (10)***void setLength(int newLength):设置当前字符序列长度为newLength***
#### 大多方法返回this，可以进行链式调用