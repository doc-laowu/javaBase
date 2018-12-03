package com.neusoft.gofmodel;

/**
 * 
 * @author Admin
 * time : 13:20 2018/8/3
 * description : 迭代器模式的泛型实现
 *
 */

public class IteratorModel {
	public static void main(String[] args) {
//		arrList<Integer> list = new arrList<Integer>(10);
//		
//		for(int i=0; i<10; i++)
//			list.add(i);
		
		arrList<String> list = new arrList<String>(4);
		
		list.add("hello ");
		list.add("world!");
		list.add("hahhah");
		list.add("lallalal");
		list.add("lallalal");
		
		myIterator<String> itr = list.getIterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next() + " ");
		}
	}
}

interface myIterator<T>
{
	boolean hasNext();
	T next();
}

interface containner<T>
{
	myIterator<T> getIterator();
}

class arrList<T> implements containner<T>
{
	private int pos = 0;
	private Object[] arr = null;
	
	public arrList(int size)
	{
		arr = new Object[size];
	}
	
	public void add(T item)
	{
		if(pos < arr.length)
			arr[pos++] = item;
	}
	
	class mySelector implements myIterator<T>
	{
		private int next = 0;
		
		@Override
		public boolean hasNext()
		{
			return next != arr.length;
		}
		
		@SuppressWarnings("unchecked")
		public T next()
		{
			return (T)arr[next++];
		}
	}
	 
	@Override
	public myIterator<T> getIterator()
	{
		return new mySelector();
	}
	
}