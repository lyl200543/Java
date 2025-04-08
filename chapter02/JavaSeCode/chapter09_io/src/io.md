# File类和io流

---

## File类
### 1.File类的理解
- File类位于`java.io`包下，本章中涉及到的相关流也都声明在java.io包下
- File类的一个对象，对应与操作系统下的一个文件或一个文件目录(或文件夹)
### 2.内部api使用说明
#### 2.1 构造器
- ①public File(String pathname) :以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储
- ②public File(string parent, String child):以parent为父路径，child为子路径创建File对象
- （parent只能是文件目录，child可以是文件目录或文件）
- ③public File(File parent，String child):根据一个父File对象和子文件路径创建File对象
- （parent只能是文件目录，child可以是文件目录或文件）

#### 2.2 方法

### 3.概念:
- 绝对路径:以windows操作系统为例，包括盘符在内的文件或文件目录的完整路径
- 相对路径:相对于某一个文件目录来讲的相对的位置。
  - 在IDEA中，如果使用单元测试方法:路径是相对于当前的module来讲的
  - 如果使用main()方法:路径是相对于当前的proiect来讲的
---

## io流