# 反射

---

## 1.Class的理解和类的加载：

### 1.1 Class类的理解(掌握)

- (如下以Java类的加载为例说明)
- 针对于编写好的.java源文件进行编译(使用javac.exe)，会生成一个或多个.class字节码文件\
- 接着，我们使用java.exe命令对指定的.class文件进行解释运行。这个解释运行的过程中，我们需要将.class字节码文件加载(
  使用类的加载器加载到内存中(存放在方法区)
- 加载到内存中的.class文件对应的结构即为Class的一个实例。
- 比如:加载到内存中的Person类或String类或User类，都作为Class的一个一个的实例
- Class clazz1=Person.class;
- Class clazz2 =String.class;
- Class clazz3 = User.class;
- Class clazz4=Comparable.class;

##### 说明:运行时类在内存中会缓存起来，在整个执行期间，只会加载一次。

### 1.2 获取Class实例的几种方式

- ①调用运行时类的静态属性：class
- ②调用运行时类的对象的getClass()
- ③调用Class的静态方法forName(String classname)
- ④使用类的加载器

### 1.3 class的实例都可以指向哪些结构呢?-->简言之，所有Java类型!

- (1)class:外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
- (2)interface:接口
- (3)[]:数组
- (4)enum:枚举
- (5)annotation:注解@interface
- (6)primitive type:基本数据类型
- (7)void

### 1.4 类的加载过程(了解)

- 过程1:类的装载(loading):将类的class文件读入内存，并为之创建一个java.lang.class对象。此过程由`类加载器`完成
- 过程2:链接(linking):
    - 验证(Verify):确保加载的类信息符合JVM规范，例如:以cafebabe开头，没有安全方面的问题
    - 准备(Prepare):正式为类变量(static)分配内存并设置类变量`默认初始值`的阶段，这些内存都将在方法区中进行分配
    - 解析(Resolve):虚拟机常量池内的`符号引用`(常量名)替换为`直接引用`(地址)的过程
- 过程3:初始化(initialization):执行类构造器<clinit>()方法的过程。
    - 类构造器<clinit>()方法是由编译期自动收集类中所有类变量的赋值动作和静态代码块中的语句合并产生的。

### 1.5 关于类的加载器(了解、JDK8版本为例)

#### 作用:负责类的加载，并对应于一个Class的实例。

#### 分类(分为两种):

- BootstrapClassLoader:引导类加载器、启动类加载器
    - 使用C/C++语言编写的，不能通过Java代码获取其实例(返回null)
    - 负责加载Java的核心库(JAVA_HOME/jre/lib/rt.jar或sun.boot.class.path路径下的内容)
- 继承于ClassLoader的类加载器:
- ExtensionClassLoader:扩展类加载器
    - 负责加载从java.ext.dirs系统属性所指定的目录中加载类库，或从JDK的安装目录的jre/lib/ext子目录下加载类库
- SystemclassLoader/ApplicationclassLoader:系统类加载器、应用程序类加载器
    - 我们自定义的类，默认使用的类的加载器。
- UserClassLoader:用户自定义类的加载器
    - 实现应用的隔离(同一个类在一个应用程序中可以加载多份);数据的加密
- 关系：ApplicationClassLoader通过`getParent()`-->ExtensionClassLoader-->BootstrapClassLoader

#### 以上的类的加载器是否存在继承关系? No!

```java
class ClassLoader {
    ClassLoader parent;

    public ClassLoader (ClassLoader parent) {
        this.parent = parent;
    }
}

//测试代码:
ClassLoader loader0 = new ClassLoader();
ClassLoader loader1 = new ClassLoader(loader0);
//我们就把loader0叫做loader1的父类加载器
 ```

---

## 2.反射的应用1：创建运行时类的对象

### 2.1 如何实现?

- 通过Class的实例调用newInstance()方法即可

### 2.2 要想创建对象成功，需要满足:

- 条件1:要求运行时类中必须提供一个空参的构造器
- 条件2:要求提供的空参的构造器的权限要足够

### 2.3 回忆:JavaBean中要求给当前类提供一个公共的空参的构造器。有什么用?

- 场景1:子类对象在实例化时，子类的构造器的首行默认调用父类空参的构造器
- 场景2:在反射中，经常用来创建运行时类的对象
- 那么我们要求各个运行时类都提供一个空参的构造器，便于我们编写通用的创建运行时类对象的代码。

### 2.4 在idk9中标识为过时，替换成什么结构

- 通过Constructor类调用newInstance(...)

---

## 3.反射的应用2：获取运行时类的内部结构

### 3.1 获取运行时类的内部结构1:所有属性、所有方法、所有构造器

### 3.2 获取运行时类的内部结构2:父类、接口们、包、带泛型的父类、父类的泛型等

---

## 4.反射的应用3:调用指定的结构:指定的属性、方法、构造器

### 4.1 调用指定的属性(步骤)

- 步骤1:通过class实例调用qetDeclaredField(string fieldName)，获取运行时类指定名的属性
- 步骤2:setAccessible(true):确保此属性是可以访问的
- 步骤3:通过Filed类的实例调用get(0bject obj)(获取的操作)
- 或set(0bject obj,0bject valve)(设置的操作)进行操作

### 4.2 调用指定的方法(步骤)

- 步骤1:通过Class的实例调用getDeclaredMethod(String methodName,class ... args),获取指定的方法
- 步骤2:setAccessible(true):确保此方法是可访问的
- 步骤3.通过Method实例调用invoke(0bject obj,0bject ... objs),即为对Method对应的方法的调用
- invoke()的返回值即为Method对应的方法的返回值
- 特别的:如果Method对应的方法的返回值类型为void，则invoke()返回值为null

### 4.3 调用指定的构造器(步骤)

- 步骤1.通过class的实例调用getDeclaredConstructor(class ... args)，获取指定参数类型的构造器
- 步骡2.setAccessible(true):确保此构造器是可以访问的
- 步骤3.通过Constructor实例调用newInstance(0bject... objs),返回一个运行时类的实例

---

## 5.反射的应用4:通过反射获取注解的信息

### 框架=反射+注解+设计模式

- 复习:自定义注解
- ①参照@SuppressWarnings 进行创建即可,
- ②注解要想通过反射的方式获取，必须声明元注解:@Retention(RetentionPolicy.RUNTIME)
