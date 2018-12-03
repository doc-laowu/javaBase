package com.neusoft.gofmodel;

public abstract class templateMethod {

	public final void run()
	{
		method_1();
		method_2();
	}
	
	protected  final void method_1()
	{
		System.out.println("模板方法第一个方法!");
	}
	
	protected abstract void method_2();
}

class concreateClass extends templateMethod
{
	protected void method_2()
	{
		System.out.println("重写后的模板方法第二个方法!");
	}
}


