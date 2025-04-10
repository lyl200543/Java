# File类和io流

---

## File类

### 1.File类的理解

- File类位于`java.io`包下，本章中涉及到的相关流也都声明在java.io包下
- File类的一个对象，对应与操作系统下的一个文件或一个文件目录(或文件夹)
- File类中声明了新建、删除、获取名称、重命名等方法，并没有涉及到文件内容的读写操作。要想实现文件内容的读写，我们就需要使用io流。
- File类的对象，通常是作为io流操作的文件的端点出现的
    - 代码层面，将File类的对象作为参数传递到I0流相关类的构造器中

### 2.内部api使用说明

#### 2.1 构造器

- ①public File(String pathname) :以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储
- ②public File(string parent, String child):以parent为父路径，child为子路径创建File对象
- （parent只能是文件目录，child可以是文件目录或文件）
- ③public File(File parent，String child):根据一个父File对象和子文件路径创建File对象
- （parent只能是文件目录，child可以是文件目录或文件）

#### 2.2 方法

##### 获取文件和目录基本信息

- public String getName():获取名称
- public String getPath():获取路径
- public String getAbsolutePath():获取绝对路径
- public File getAbsoluteFile():获取绝对路径表示的文件
- public String getParent():获取上层文件目录路径。若无，返回null
- public long length():获取文件长度(即:字节数)。不能获取目录的长度
- public long lastModified():获取最后一次的修改时间，毫秒值

##### 列出目录的下一级

- public String[] list():返回一个String数组，表示该File目录中的所有子文件或目录。
- public File[] listFiles():返回一个File数组，表示该File目录中的所有的子文件或目录。

##### File类的重命名功能

- public boolean renameTo(File dest):把文件重命名为指定的文件路径
- 注意：file1.renameTo(file2):要想此方法执行完返回true。
- 要求:file1必须存在，且file2必须不存在，且file2所在的文件目录需要存在

##### 判断功能的方法

- public boolean exists():此File表示的文件或目录是否实际存在
- public boolean isDirectory():此File表示的是否为目录。
- public boolean isFile():此File表示的是否为文件。
- public boolean canRead():判断是否可读
- public boolean canWrite():判断是否可写
- public boolean isHidden():判断是否隐藏

##### 创建、删除功能

- public boolean createNewFile():创建文件。若文件存在，则不创建，返回false。
- public boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
- public boolean mkdirs():创建文件目录。如果上层文件目录不存在，一并创建。
- public boolean delete():删除文件或者文件夹
- 删除注意事项:① Java中的删除不走回收站。② 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录。

### 3.概念:

- 绝对路径:以windows操作系统为例，包括盘符在内的文件或文件目录的完整路径
- 相对路径:相对于某一个文件目录来讲的相对的位置。
    - 在IDEA中，如果使用单元测试方法:路径是相对于当前的module来讲的
    - 如果使用main()方法:路径是相对于当前的proiect来讲的

---

## io流

### 1.io流的概述：

#### 1.1 IO流的分类

- 流向的不同:输入流、输出流
- 处理单位的不同:字节流、字符流
- 流的角色的不同:节点流、处理流
    - 节点流:直接从数据源或目的地读写数据
    - 处理流:不直接连接到数据源或目的地，而是“连接”在已存在的流(节点流或处理流)之上，通过对数据的处理为程序提供更为强大的读写功能

#### 1.2 基础I0流的框架:

 抽象基类 | 输入流         | 输出流          
------|-------------|--------------|
 字节流  | InputStream | 0utputStream 
 字符流  | Reader      | Writer       

 抽象基类         | 4个节点流(也称为文件流)    | 4个缓冲流(处理流的一种)        
--------------|------------------|----------------------|
 InputStream  | FileInputStream  | BufferedInputStream  
 0utputStream | File0utputStream | BufferedOutputStream 
 Reader       | FileReader       | BufferedReader       
 Writer       | FileWriter       | BufferedWriter       

### 2.文件流的使用：

#### 2.1 FileReader/FileWriter的使用

##### 2.1.1 执行步骤:

- 第1步:创建读取或写出的File类的对象
- 第2步:创建输入流或输出流
- 第3步:具体的读入或写出的过程
- 读入:read(char[] cbuffer)
- 写出:write(string str)/write(char[] cbuffer,0,len)
- 第4步:关闭流资源，避免内存泄漏

##### 2.1.2 注意点:

- ①因为涉及到流资源的关闭操作，所以出现异常的话，需要使用try-catch-finally的方式来处理异常
- ②对于输入流来讲，要求File类的对象对应的物理磁盘上的文件必须存在。否则，会报FileNotFoundException
- ③对于输出流来讲，File类的对象对应的物理磁盘上的文件可以不存在。
    - 如果此文件不存在，则在输出的过程中，会自动创建此文件，并写出数据到此文件中
    - 如果此文件存在，使用 FileWriter(File file)或 FileWriter(File file,false):输出数据过程中，会新建同名的文件对现有的文件进行覆盖
    - 使用FileWriter(File file,true):输出数据过程中，会在现有的文件的末尾追加写出内容

#### 2.2 FileInputStream/FileOutputStream的使用

##### 2.2.1 执行步骤:

- 第1步:创建读取或写出的File类的对象
- 第2步:创建输入流或输出流
- 第3步:具体的读入或写出的过程。
- 读入:read(byte[] buffer)
- 写出:write(byte[] buffer,0,len)
- 第4步:关闭流资源，避免内存泄漏

##### 2.2.2 注意点:

- 在2.1.2注意点的基础之上，其他的注意点。
- 对于字符流，只能用来操作文本文件，不能用来处理非文本文件的
- 对于字节流，通常是用来处理非文本文件的。但是，如果涉及到文本文件的复制操作，也可以使用字节流
- 说明:
- 文本文件:.txt、.java、.c、.cpp、.py等
- 非文本文件:.doc、.xls、.jpg、·pdf、.mp3、.mp4、.avi 等

### 3.缓冲流的使用：

#### 3.1 作用：

- 读写操作涉及和磁盘的交互，通过缓冲流可以将几次读写操作合并为一次，减少和磁盘的交互，提高传输效率
- 缓冲流通过在内存中设置`缓冲区`，将多次的读写操作合并为一次或少数几次与底层设备的交互，减少了系统调用的次数，从而显著提高了
  I/O 操作的效率

#### 3.2 使用的方法

##### 处理非文本文件的字节流:BufferedInputStream\Buffered0utputStream

- read(byte[] buffer)
- write(byte[] buffer,0,len)/flush()

##### 处理文本文件的字符流:BufferedReader\BufferedWriter

- read(char[] cBuffer)/String readLine()
- write(char[], cBuffer,0,len)/write(String )/flush()
    - flush()(刷新的方法。每当调用此方法时，就会主动的将内存中的数据写出到磁盘文件中)
    - close()(资源关闭时，会自动刷新)

### 4.转换流的使用：

#### 4.1

- 字符编码:字符、字符串、字符数组---> 字节、字节数组(从我们能看得懂的--->我们看不懂的)
- 字符解码:字节、字节数组 ---> 字符、字符串、字符数组(从我们看不懂的--->我们能看得懂的)

#### 4.2 如果希望程序在读取文本文件时，不出现乱码，需要注意什么?

- 解码时使用的字符集必须与当初编码时使用的字符集得相同。
- 拓展:解码集必须要与编码集兼容。比如、文件编码使用的是GBK，解码时使用的是utf-8。如果文件中只有abc等英文字符
- 也不会出现乱码，因为GBK和utf-8都向下兼容了ASCII(或ascii)

#### 4.3 转换流:

- ① 作用:实现字节与字符之间的转换
- ② API:
- InputStreamReader:将一个输入型的字节流转换为输入型的字符流
- 0utputstreamWriter:将一个输出型的字符流转换为输出型的字节流
- ③应用：将GBK存储的文件变为UTF-8存储

#### 4.4 字符集

##### 4.4.1 在存储的文件中的字符

- ascii:主要用来存储a、b、c等英文字符和1、2、3、常用的标点符号。每个字符占用1个字节。
- iso-8859-1:了解，每个字符占用1个字节。向下兼容ascii。
- gbk:用来存储中文简体繁体、a、b、c等英文字符和1、2、3、常用的标点符号等字符。
    - 中文字符使用2个字节存储的。向下兼容ascii，意味着英文字符、1、2、3、标点符号仍使用1个字节。
- utf-8:可以用来存储世界范围内主要的语言的所有的字符。使用1-4个不等的字节表示一个字符。
    - 中文字符使用3个字节存储的。向下兼容ascii，意味着英文字符、1、2、3、标点符号仍使用1个字节。

##### 4.1.2 在内存中的字符

- 一个字符(char)占用2个字节。在内存中使用的字符集称为Unicode字符集

### 5. 对象流的使用：

#### 5.1 数据流（了解）：

- Data0utputstream:可以将内存中的基本数据类型的变量、String类型的变量写出到具体的文件中
- DataInputStream:将文件中保存的数据还原为内存中的基本数据类型的变量、string类型的变量

#### 5.2 对象流及其作用：

##### 5.2.1 API:

- 0bjectInputSteam
- 0bjectOutputStream

##### 5.2.2 作用:

- 可以读写基本数据类型的变量、`引用数据类型`的变量。

#### 5.3 对象的序列化机制是什么

- 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进训流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点
- 当其它程序获取了这种二进制流，就可以恢复成原来的Java对象

#### 5.4 如下两个过程使用的流:

- 序列化过程:使用0bject0utputStream流实现。将内存中的Java对象保存在文件中或通过网络传输出去
- 反序列化过程:使用0biectInputSteam流实现。将文件中的数据或网络传输过来的数据还原为内存中的Java对象

#### 5.5 自定义类要想实现序列化机制，需要满足:

- 自定义类需要实现接口:Serializable
- 要求自定义类声明一个全局常量: static final long serialVersionUID = 42234234L;用来唯一的标识当前的类。
- 要求自定义类的各个属性也必须是可序列化的
    - 对于基本数据类型的属性:默认就是可以序列化的
    - 对于引用数据类型的属性:要求实现Serializable接口

#### 5.6 注意点:

- ①如果不声明全局常量serialVersionUID，系统会自动声明生成一个针对干当前类的serialVersionUID
- 如果修改此类的话，会导致serialVersionUID变化，进而导致反序列化时，出现InvalidclassException异常
- ②类中的属性如果声明为transient（暂时的）或static，则不会实现序列化

