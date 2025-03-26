package Class_Base;

/**
 * ClassName: exer1
 * Package: Class_Base
 * Description:创建于 2025/3/21 20:36
 *
 * @Author lyl
 * @Version 1.0
 */

//字符串不可变性：String 对象的内容在创建后不能被修改
//每次对字符串进行操作（如拼接、截取等），都会生成一个新的字符串对象
//String str = "Hello";
//str = str + " World"; // 这里看起来像是修改了 str，但实际上创建了一个新的字符串对象
//System.out.println(str); // 输出：Hello World
//在这个例子中，str + " World" 会创建一个新的字符串对象 "Hello World"
//然后将引用 str 指向这个新对象。原来的 "Hello" 字符串对象仍然存在，只是没有被引用了


//n个字符串进行拼接，每一个字符串之间使用某字符进行分割，如果没有传入字符串，那么返回空字符串""

public class Length_Variable_args_exer {
    public static void main(String[] args){
        Length_Variable_args_exer obj=new Length_Variable_args_exer();
        System.out.println(obj.StringConCat('-',"hello","world"));

    }

    public String StringConCat(char operator, String ... strs){
        String string = "";
        for(int i=0; i<strs.length; i++){
            if(i==0){
                string+=strs[i];
            }
            else{
                string+=(operator + strs[i]);
            }
        }
        return string;
    }
}
