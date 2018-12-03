package com.neusoft.gofmodel;

public class singletonMode 
{
//	public static void main(String[] args) 
//	{
//		// TODO Auto-generated method stub
//		
//		int[] a = {2,1,5,4,8,7,9,10};
//		
//		strategyMode ptr = new strategyMode(new directInsertSort());
//		
//		ptr.excuteStragy(a);
//		
//		for(int x : a)
//		{
//			System.out.print(x+" ");
//		}
//		
//	}
}


/**
 * 
 * @author Admin
 * description: model of singalton. this is not thread safe.
 *
 */
class singalton
{
	private singalton() {}
	
	public static singalton getInstance()
	{
		if(Instance == null)
		{
			Instance = new singalton();
		}
		return Instance;
	}
	
	private static singalton Instance;
}

/**
 * 
 * @author Admin
 * description: model of singalton. this is thread safe.
 *
 */

class singalton_2
{
	private singalton_2() {}
	
	public static singalton_2 getInstance()
	{
		return Instance;
	}
	
	private static singalton_2 Instance = new singalton_2();
}


/**
 * 
 * @author Admin
 * description: model of singalton. this is thread safe. by enum.
 *
 */
class singalton_3
{
	private singalton_3() {}
	
	public static singalton_3 getInstance()
	{
        return enumSingalton.INSTANCE.getter();
    }
	
	private static enum enumSingalton
	{
		INSTANCE;
		
		private singalton_3 Instance;
		
		private enumSingalton()
		{
			Instance = new singalton_3();
		}
		
		public singalton_3 getter()
		{
			return Instance;
		}
	}
}















