package Class_Improvement.Polymorphism;

/**
 * ClassName: exer
 * Package: Class_Improvement.Polymorphism
 * Description:创建于 2025/3/23 13:49
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer {
    public static void main (String[] args) {
        Person p1=new Man();
        Person p2=new Woman();
        meeting(p1,p2);
    }

    public static void meeting(Person...ps){
        for(int i=0;i<ps.length;i++){
            ps[i].eat() ;
            ps[i].toilet() ;
            if(ps[i] instanceof Man m){
//                Man man=(Man)ps[i];
//                man.smoke() ;
                m.smoke() ;
            }
            if(ps[i] instanceof Woman){
                Woman woman=(Woman)ps[i];
                woman.makeup() ;
            }
            System.out.println();
        }
    }
}
