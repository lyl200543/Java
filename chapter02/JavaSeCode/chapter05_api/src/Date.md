# Date

---
## 1.JDK8之前的API:
### 1.1 System类的currentTimeMillis()
- 获取当前时间对应的毫秒数，long类型，时间戳
- 当前时间与1970年1月1日0时0分0秒之间的毫秒数
- 常用来计算时间差
### 1.2 两个Date类
#### java.util.Date类
- 两个构造器：
  - new Date()
  - new Date(long Date)
- 两个方法：
  - String toString()  打印类似 Thu Apr 03 17:14:00 CST 2025
  - long getTime() 返回距离起点的毫秒数
#### java.sql.Date类(java.util.Date类的子类)
- 构造器：new Date(Long Date)  打印类似 1984-07-26
### 1.3 SimpleDateFormat类
- 用于日期时间的格式化和解析
- 字符串的格式由构造器传入的参数决定
- 格式化:日期--->字符串  String format(Date date)
- 解析:字符串--->日期   Date parse(String str)
### 1.4 Calendar类(日历类):抽象类
- ①实例化：由于calendar是一个抽象类，所以我们需要创建其子类的实例，这里我们通过calendar的静态方法getInstance()即可获取
- ②常用方法:get(int field)/ set(int field,xx)/ add(int field,xx)/ getTime()/ setTime()
---
## 2.JDK8中的API:
### JDK8之前的API的缺点：
- 可变性:像日期和时间这样的类应该是不可变的
- 偏移性:Date中的年份是从1900开始的，而月份都从0开始
- 格式化:格式化只对Date有用，Calendar则不行
- 此外，它们也不是线程安全的;不能处理闰秒等
### 2.1 LocalDate,LocalTime,LocalDateTime --->类似于Calendar
- 实例化:
- now():获取当前日期和时间对应的实例
- of(xxx,xx,xx):获取指定日期和时间的实例
- 方法:get()/withXxx()/plusXxx()/minusXxx()
### 2.2 Instant:瞬时 --->类似于Date
- 实例化:now()/ofEpochMilli()
- 方法:toEpochMilli()
### 8.3 DateTimeFormatter--->类似于SimpleDateFormat
- 用于格式化和解析LocalDate,LocalTime,LocalDateime


