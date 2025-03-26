//Math.random()
//返回带有正号的double值，大于或等于0.0且小于1.0。
//如果想要[a,b]之间的随机数--> (int)(Math.random()*(b-a+1)+a)

class RandomTest 
{
	public static void main(String[] args)
	{
		int random=(int)(Math.random()*101); //[0,100]
		random=(int)(Math.random()*37+36);//[36,72]
		System.out.println("random="+random);
	}
}
