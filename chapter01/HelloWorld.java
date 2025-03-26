class HelloChina{
	public static void main(String[] args){
		System.out.println("hello,world!! 你好，中国！！");	
	}
}


总结：
1.编写：将Java代码编写在.java结尾的源文件中
2.编译：针对于.java结尾的源文件进行编译操作，格式: javac 源文件名.java
3.运行：针对于编译后生成的字节码文件，进行解释运行，格式: java 字节码文件名

补充：
1.编译以后会生成一个或多个字节码文件，每个字节码文件对应一个java类，且字节码文件名与类名相同
2.一个源文件中可以声明多个类，但是最多只能有一个类使用public进行声明，且要求声明为public的类的类名与源文件名相同
3.java严格区分大小写，windows不区分大小写