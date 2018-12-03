package com.neusoft.javaClass;


public class staticInitArea
{
	public static void main(String[] args)
	{
		//zoo.b1.f(99);
//		staticInitArea ptr = new staticInitArea();
//		//ptr.run();
//		System.out.println(ptr);
		
		
	}
	
}


class zoo
{
	static bird b1;
	static bird b2;
	
	bird b3;
	bird b4;
	
	//静态代码初始块
	static 
	{
		b1 = new bird(1);
		b2 = new bird(2);
	}
	
	{
		b3 = new bird(3);
		b4 = new bird(4);
	}
	
	zoo()
	{
		System.out.println("zoo()");
	}
}

class bird
{
	bird(int marker)
	{
		System.out.println("bird("+marker+")");
	}
	void f(int marker)
	{
		System.out.println("f("+marker+")");
	}
}
