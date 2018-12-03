package com.neusoft.javaClass;


/**
 * 
 * @author Admin
 * time : 12点24分 2018/7/27
 * description : 当父类引用指向子类对象时，如果直接访问子类某个域的话，
 * 				这个访问将在编译期进行解析。
 *
 */

public class FiledAccess {
	public static void main(String[] args) {
		
//		Super sup = new Sub();
//		System.out.println(sup.field+" "+sup.getField());
//		
//		Sub sub = new Sub();
//		System.out.println(sub.field+" "+sub.getField()+" "+sub.getSuperField());
		
		
		
	}
}

class Super
{
	public int field = 0;
	public int getField()
	{
		return field;
	}
}

class Sub extends Super
{
	public int field = 1;
	public int getField()
	{
		return field;
	}
	public int getSuperField()
	{
		return super.field;
	}
}





