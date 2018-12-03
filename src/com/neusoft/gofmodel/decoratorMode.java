package com.neusoft.gofmodel;

/**
 * 
 * @author Admin
 * time : 10点47分 2018/7/25
 * description : 装饰模式
 *
 */

public class decoratorMode {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Component pptr = new Component_Reality();
//		ConcreateComponent_2 ptr = new ConcreateComponent_2(pptr);
//		ConcreateComponent_1 ptr2 = new ConcreateComponent_1(pptr);
//		ptr.operation();
//		ptr2.operation();
//	}

}


abstract class Component
{
	public abstract void operation();
}

class Component_Reality extends Component
{
	@Override
	public void operation()
	{
		System.out.println("组件的具体类!");
	}
}

abstract class ComponentDecorator extends Component
{	
	private Component component;
	
	public ComponentDecorator(Component component)
	{
		this.component = component;
	}
	
	@Override
	public void operation()
	{
		System.out.println("在装饰器中扩展了操作1!");
		component.operation();
	}
}

class ConcreateComponent_1 extends ComponentDecorator
{
	public ConcreateComponent_1(Component component)
	{
		super(component);
	}
	
	@Override
	public void operation()
	{
		System.out.println("在继承的构造器的子类1中扩展了操作2!");
		super.operation();
	}
}

class ConcreateComponent_2 extends ComponentDecorator
{
	public ConcreateComponent_2(Component component)
	{
		super(component);
	}
	
	public void operation()
	{
		System.out.println("在继承的构造器的子类2中扩展了操作3!");
		super.operation();
	}
}
