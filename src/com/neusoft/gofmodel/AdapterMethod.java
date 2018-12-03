package com.neusoft.gofmodel;

import java.util.*;

public class AdapterMethod {
	public static void main(String[] args) {
		ReversibleArrayList<String> ral = 
				new ReversibleArrayList<String>(
						Arrays.asList("to be or not to be".split(" ")));
		
		for(String x : ral)
			System.out.print(x+" ");
		System.out.println("");
		
		for(String x : ral.reversed())
			System.out.print(x+" ");
		
	}	
}

@SuppressWarnings("serial")
class ReversibleArrayList<T> extends ArrayList<T>
{
	public ReversibleArrayList(Collection<T> c)
	{
		super(c);
	}
	
	public Iterable<T> reversed()
	{
		return new Iterable<T>()
		{
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>()
				{
					private int current = size()-1;
					@Override
					public boolean hasNext() {
						return current > -1;
					}

					@Override
					public T next() {
						return get(current--);
					}
				
				};
			}
			
		};
	}
}



































