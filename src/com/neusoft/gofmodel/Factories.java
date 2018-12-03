package com.neusoft.gofmodel;

/**
 * 
 * @author Admin
 *	time : 23点46分 2018/7/29
 *	description : 基于匿名内部类的抽象工厂模式
 */


public class Factories {
	public static void serviceComsumer(ServiceFactory fact)
	{
		Service s = fact.getService();
		s.method1();
		s.method2();
	}
	
	public static void main(String[] args) {
		serviceComsumer(Impletmentation1.factory);
		serviceComsumer(Impletmentation2.factory);
	}
}


interface Service
{
	void method1();
	void method2();
}

interface ServiceFactory
{
	Service getService();
}

class Impletmentation1 implements Service
{
	private Impletmentation1() {}
	public void method1()
	{
		System.out.println("Impletmentation1 method1");
	}
	public void method2()
	{
		System.out.println("Impletmentation1 method2");
	}
	
	//在此处ServiceFactory接口继承了Service接口
	
	public static ServiceFactory factory = 
		new ServiceFactory()
		{
			public Service getService()
			{
				return new Impletmentation1();
			}
		};
}

class Impletmentation2 implements Service
{
	private Impletmentation2() {}
	public void method1()
	{
		System.out.println("Impletmentation2 method1");
	}
	public void method2()
	{
		System.out.println("Impletmentation2 method2");
	}
	
	public static ServiceFactory factory = 
			new ServiceFactory()
			{
				public Service getService()
				{
					return new Impletmentation2();
				}
			};
}














