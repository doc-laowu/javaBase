package com.neusoft.javaClass;

/**
 * 
 * @author Admin
 *	time : 18点09分 2018/7/28
 *	description : 基于内部类的迭代器模式的实现
 */

public class Sequence {
	
	private Object[] items;
	private int next = 0;
	
	public Sequence(int size)
	{
		items = new Object[size];
	}
	
	public void add(Object x)
	{
		if(next < items.length)
			items[next++] = x;
	}
	
	private class SequenceSelector implements Selector
	{
		private int i = 0;
		
		public boolean end()
		{
			return i == items.length;
		}
		
		public Object current()
		{
			return items[i];
		}
		
		public void next()
		{
			if(i < items.length)
				i++;
		}
	}
	
	public Selector selector()
	{
		return new SequenceSelector();
	}
	
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for(int i = 0; i < 10; i++)
		{
			sequence.add(i);
		}
		//Selector selector = sequence.selector();
		//另外一种实例化内部类对象的方式
		Selector selector = sequence.new SequenceSelector();
		
		while(!selector.end())
		{
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
	
}

interface Selector
{
	boolean end();
	Object current();
	void next();
}

