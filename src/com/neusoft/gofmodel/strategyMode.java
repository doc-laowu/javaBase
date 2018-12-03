package com.neusoft.gofmodel;

public class strategyMode {
	
	private strategy member;
	
	strategyMode(strategy member)
	{
		this.member = member;
	}
	
	public void excuteStragy(int... array)
	{
		member.doOperation(array);
	}
}


interface strategy
{
	//使用了java1.5的可变参数
	public void doOperation(int... array);
	
	 //这个是默认方法
    default String get(String aa){
        System.out.println("我是jdk1.8默认实现方法...");
        return "";
    }   
    //这个是静态方法    
    static void staticmethod(){
        System.out.println("我是静态方法");
    }
}


class sortBubble implements strategy
{
	public void doOperation(int... array)
	{
		for(int i=0; i<array.length; i++)
		{
			for(int j=0; j<array.length-i-1; j++)
			{
				if(array[j] > array[j+1])
				{
					array[j] ^= array[j+1];
					array[j+1] ^= array[j];
					array[j] ^= array[j+1];
				}
			}
		}
	}
}

class sortSelect implements strategy
{
	public void doOperation(int... array)
	{
		int pos, itemp;
		for(int i=0; i<array.length-1; i++)
		{
			pos = i;
			itemp = array[i];
			
			for(int j=i+1; j<array.length; j++)
				if(itemp > array[j])
				{
					pos = j;
					itemp = array[j];
				}
			
			array[pos] = array[i];
			array[i] = itemp;
		}
	}
}

class directInsertSort implements strategy
{
	public void doOperation(int... array)
	{
		int pos, itemp;
		
		for(int i=0; i<array.length; i++)
		{
			itemp = array[i];
			pos = i-1;
			
			while(pos >= 0 && array[pos] > itemp)
			{
				array[pos+1] = array[pos];
				pos--;
			}
			array[pos+1] = itemp; 
		}
	}

	public static void main(String[] args) {

		int[] arr = {22,4,6,8,9,12,35,789};

		strategyMode ptr = new strategyMode(new directInsertSort());
		ptr.excuteStragy(arr);

		for(int o : arr)
			System.out.print(o+" ");
	}
}

class quickSort
{
	public void doOperation(int[] array, int low, int high)
	{
		if(low >= high)
			return ;
		
		int first = low;
		int last = high;
		int key = array[low];
		
		while(first < last)
		{
			while(first < last && array[last] >= key)
			{
				last--;
			}
			array[first] = array[last];
			
			while(first < last && array[first] <= key)
			{
				first++;
			}
			array[last] = array[first];
		}
		
		array[first] = key;
		
		doOperation(array, low, first-1);
		doOperation(array, first+1, high);
	}
}























