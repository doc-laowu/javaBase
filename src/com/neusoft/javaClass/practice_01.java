package com.neusoft.javaClass;

import java.util.Scanner;

public class practice_01 {
	
	public void changeValue()
	{
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		if( num1+num2 > Integer.MAX_VALUE )
		{
			System.out.println("您输入的两个值太大，无法进行交换!");
			scan.close();
			return ;
		}
		num1 += num2; 
		num2 = num1 - num2; 
		num1 -= num2;
		System.out.println("num1:"+num1+" num2:"+num2);
		scan.close();
	}
	
	public void display9_4()
	{
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<i; j++)
				System.out.print(" ");
			
			for(int k=0; k<9; k++)
				System.out.print("*");
			System.out.println("");
		}
	}
	
	public void display7_4()
	{
		for(int i=0; i<4; i++)
		{
			for(int j=3-i; j>0; j--)
			{
				System.out.print(" ");
			}
			
			for(int j=0; j<2*i+1; j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public void getPrimeNum()
	{
		int count = 2;
		
		for(int i=1; i<100; i+=2)
		{
			for(int j=2; j<=(int)Math.sqrt(i); j++)
			{
				if(i%j == 0)
					break;
				if(j >= (int)Math.sqrt(i))
				{
					count++;
				}
			}
		}
		
		System.out.println("total:"+count);
	}
	
	public void ComparisonValue()
	{
		System.out.println("请输入三个数:");
		
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		int min = (num1>num2?num2:num1)<(num2>num3?num3:num2)?
				(num1>num3?num3:num1):(num2>num3?num3:num2);
		
		int max = (num1>num2?num1:num2)>(num2>num3?num2:num3)?
				(num1>num3?num1:num2):(num2>num3?num2:num3);
				
		int middle = (num1+num2+num3)-max-min;
				
		System.out.println(min+" "+middle+" "+max);
		
		scan.close();
	}

	public void todayIsWhere()
	{
		int[] mArr = {31,28,31,30,31,30,31,31,30,31,30,31};
		Scanner scan = new Scanner(System.in);
		
		int year = scan.nextInt();
		int month = scan.nextInt();
		int day = scan.nextInt();
		
		if((year%100!=0&&year%4==0)||(year%400 == 0))
			mArr[1] = 29;
		else
			mArr[1] = 28;
		
		int count = 0;
		
		for(int i=0; i<month-1; i++)
		{
			count+=mArr[i];
		}
		
		
		System.out.println(count+day);
		scan.close();
	}
	
	public void getMultiple()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("请输入两个数:");
		
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		for(int i=(n<m?n:m); i>0; i--)
		{
			if(m%i == 0 && n%i == 0)
			{
				System.out.println("最大公约数:"+i);
				break;
			}		
		}
		
		for(int i=(n<m?n:m); i<n*m; i++)
		{
			if(i%m == 0 && i%n == 0)
			{
				System.out.println("最小公倍数:"+i);
				break;
			}
		}
		
		scan.close();
	}

	public void getNoRepeatNum()
	{
		for(int i=1; i<5; i++)
		{
			for(int j=1; j<5; j++)
			{
				for(int k=1; k<5; k++)
				{
					if(i != j && j != k && i != k)
						System.out.println(i+""+j+""+k);
				}
			}
		}
	}
	
	public void getTotalRabbits(int month)
	{
		
		int a = 1, b = 1, tmp = 0;
		
		System.out.println(a);
		
		System.out.println(b);
		
		for(int i=2; i<month; i++)
		{
			System.out.println(a+b);
			tmp = a;
			a = b;
			b += tmp;
		}

	}
	
	public int isShuiXianHuaShu(int num)
	{
		int gewei = num%10;
		int shiwei = num/10%10;
		int baiwei = num/100;
		
		if(num == (gewei*gewei*gewei+shiwei*shiwei*shiwei+baiwei*baiwei*baiwei))
		{
			return 1;
		}
		
		return 0;
	}
	
	public void fillArray()
	{
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++)
		{
			arr[i] = scan.nextInt();
		}
		
		scan.close();
	}
	
	public void reverseArr()
	{
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int i=0,j=arr.length-1, tmp;
		for(int k=0; k<arr.length/2; k++)
		{
			tmp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = tmp;
		}
	}
	
	public static void main(String args[]) {
		practice_01 ptr = new practice_01();
		//ptr.display9_4();
		//ptr.display7_4();
		//ptr.getPrimeNum();
		//ptr.ComparisonValue();
		//ptr.getMultiple();
		//ptr.getNoRepeatNum();
		//ptr.getTotalRabbits(20);
		//System.out.println(ptr.isShuiXianHuaShu(377));
		ptr.reverseArr();
	}
	
}
