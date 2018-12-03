package com.neusoft.gofmodel;

import java.util.*;

/**
 * 
 * @author Admin
 *	time : 09点02分 2018/8/9
 *	description : 这是命令模式
 */

public class OrderPattern {
	public static void main(String[] args) {
		
		 Stock abcStock = new Stock("A股",10000000);
		 
	     BuyStock buyStockOrder = new BuyStock(abcStock);
	     SellStock sellStockOrder = new SellStock(abcStock);
	 
	     Invoker broker = new Invoker();
	     broker.takeOrder(buyStockOrder);
	     broker.takeOrder(sellStockOrder);
	 
	     broker.excuteOrder();

	}
}

class Stock
{
	private String name;
	private int quantity;
	
	public Stock(String name, int quantity)
	{
		this.name = name;
		this.quantity = quantity;
	}
	
	public void buy()
	{
		System.out.println("buy the stock:"+name+" quantity:"+quantity);
	}
	
	public void sell() 
	{
		System.out.println("sell the stock:"+name+" quantity:"+quantity);
	}
}

interface Order
{
	void excute();
}

class BuyStock implements Order
{
	private Stock st = null;
	
	public BuyStock(Stock st)
	{
		this.st = st;
	}
	
	public void excute()
	{
		st.buy();
	}
}

class SellStock implements Order
{
	private Stock st = null;
	
	public SellStock(Stock st)
	{
		this.st = st;
	}
	
	public void excute()
	{
		st.sell();
	}
}

class Invoker 
{
	private List<Order> orders = new ArrayList<Order>();
	
	public void takeOrder(Order o)
	{
		orders.add(o);
	}
	
	public void excuteOrder()
	{
		for(Order o : orders)
			o.excute();
	}
}
















