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
## 2.