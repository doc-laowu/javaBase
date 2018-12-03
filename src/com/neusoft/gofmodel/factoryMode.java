package com.neusoft.gofmodel;

/**
 * 
 * @author Admin
 *  time : 17点18分 2018/7/26
 *  description : 简单工厂模式
 *  
 */

public class factoryMode {
	public static void main(String[] args) {
		Factory ptr = new Factory();
		ptr.createProduct("huawei").shengchan();
		ptr.createProduct("apple").shengchan();
	}
}


class Factory
{	
	public Product createProduct(String type)
	{
		if(type == null)
		{
			return null;
		}
		else if(type.equalsIgnoreCase("huawei"))
		{
			return new huawei();
		}
		else if(type.equalsIgnoreCase("apple"))
		{
			return new apple();
		}
		else
		{
			return null;
		}
	}
}

interface Product
{
	public void shengchan();
}

class huawei implements Product
{
	@Override
	public void shengchan()
	{
		System.out.println("生产华为手机");
	}
}

class apple implements Product
{
	@Override
	public void shengchan()
	{
		System.out.println("生产苹果手机");
	}
}