package com.neusoft.javaClass;

public class practice_02 {
	public void wordCount(String str)
	{
		int cCount = 0, spaceCount = 0, numCount=0, othCount=0;
		
		for(int i=0; i<str.length(); i++)
		{
			if((str.charAt(i) >= 'a' && str.charAt(i)<='z') || 
					(str.charAt(i) >= 'A' && str.charAt(i)<='Z'))
			{
				cCount++;
			}
			else if((str.charAt(i) >= '0' && str.charAt(i)<='9'))
			{
				numCount++;
			}
			else if(str.charAt(i) == ' ')
			{
				spaceCount++;
			}
			else
			{
				othCount++;
			}
		}
		System.out.println("英文字母:"+cCount+"空格:"+spaceCount
				+"数字:"+numCount+"其它字符"+othCount);
	}
	
	public <T> void isReverse(T content)
	{
		if(content instanceof String)
		{
			String str = (String)content;
			for(int i=0; i<str.length()/2; i++)
			{
				if(str.charAt(i) != str.charAt(str.length()-i-1))
				{
					System.out.println(str+"不是回文字");
					return;
				}
			}
			System.out.println(str+"是回文字");
		}
		if(content instanceof Integer)
		{
			int num = ((Integer)content).intValue(), i=0;
			int[] arr = new int[20];
			while(num != 0)
			{
				arr[i++] = num%10;
				num/=10;
			}
			for(int j=0; j<i/2; j++)
			{
				if(arr[j] != arr[i-j-1])
				{
					System.out.println(((Integer)content).intValue()+"不是回文字");
					return;
				}
			}
			System.out.println(((Integer)content).intValue()+"是回文字");
		}
	}
	
	public void displayPascal(int layers)
	{
	    final int m = 2 * layers-1;
	    int[][] arr = new int[layers + 1][m];
	    for (int i = 0; i < layers; i++)
	    {
	        arr[i][layers - i- 1] = 1;
	        arr[i][layers + i -1] = 1;
	 
	    }
	    for (int i = 2; i < layers; i++)
	    {
	        for (int j = layers - i + 1; j < layers-2+i; j = j + 2)
	            arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
	    }
	    int p;
	    for (int i = 0; i < layers; i++)
	    {
	        for (int j = 0; j < layers - i - 1; j++)
	            System.out.print(" ");
	        p = 1;
	        for (int j = layers - i - 1; p < i + 2; j = j + 2)
	        {
	            System.out.print(arr[i][j]+" ");
	            p = p + 1;
	        }
	        System.out.println("");
	    }
	}
	
	public int CountTaozi(int n)
	{
		return 3*(2<<(n-1))-2;
	}
	
	public int CountTaozi2(int n)
	{
		if(1 == n)
			return 1;
		else
			return CountTaozi(n-1)+1/2;
		
	}

	
	public static void main(String[] args) {
		practice_02 ptr = new practice_02();
		//ptr.wordCount("123AzxcASD <> ||");
		//ptr.isReverse("aaaaaa");
		//ptr.displayPascal(6);
		System.out.println(ptr.CountTaozi2(4));
	}
}

abstract class pet 
{	
	private String color;
	private String breed;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public abstract void eat();
}

class Cat extends pet
{
	public Cat() {}
	public Cat(String color, String breed) 
	{
		setColor(color);
		setBreed(breed);
	}
	
	public String getColor() {
		return super.getColor();
	}

	public void setColor(String color) {
		super.setColor(color);
	}

	public String getBreed() {
		return super.getBreed();
	}

	public void setBreed(String breed) {
		super.setBreed(breed);
	}
	
	public void eat()
	{
		System.out.println(getColor()+getBreed()+"正在吃鱼.....");
	}
	
	public void catchMouse()
	{
		System.out.println(getColor()+getBreed()+"正在逮老鼠....");
	}
}


class Dog extends pet
{
	public Dog() {}
	public Dog(String color, String breed) 
	{
		setColor(color);
		setBreed(breed);
	}
	
	public String getColor() {
		return super.getColor();
	}

	public void setColor(String color) {
		super.setColor(color);
	}

	public String getBreed() {
		return super.getBreed();
	}

	public void setBreed(String breed) {
		super.setBreed(breed);
	}
	
	public void eat()
	{
		System.out.println(getColor()+getBreed()+"正在啃骨头......");
	}
	
	public void lookHome()
	{
		System.out.println(getColor()+getBreed()+"正在看家.....");
	}
}


class Vehicle
{
	private String type;
	
	public final void setType(String type) {
		this.type = type;
	}

	private String color;
	private int seats;
	
	public Vehicle(String color, int seats)
	{
		this.color = color;
		this.seats = seats;
	}
	
	public void showDetail()
	{
		System.out.println("类型:"+type);
		System.out.println("颜色:"+color);
		System.out.println("载客数:"+seats);
	}
	
	public void speedControl(int speed)
	{
		if(speed >= 20 && speed <= 50)
			setType("ship");
		else if(speed >= 80 && speed <= 140)
			setType("car");
		else if(speed >= 200)
			setType("plane");
		else
			setType(null);
	}
}

class Car extends Vehicle
{
	private int speed;
	
	public Car(String color, int seats)
	{
		super(color, seats);
	}
	
	public void speedControl(int speed)
	{
		if(speed >= 80 && speed <= 160)
			super.setType("Car");
	}
	
	public void showDetail()
	{
		super.showDetail();
		System.out.println("速度"+speed);
	}
}

class Ship extends Vehicle
{
	private int speed;
	public Ship(String color, int seats)
	{
		super(color, seats);
	}
	
	public void showDetail()
	{
		super.showDetail();
		System.out.println("速度"+speed);
	}
}

class Plane extends Vehicle
{
	private int speed;
	public Plane(String color, int seats)
	{
		super(color, seats);
	}
	
	public void showDetail()
	{
		super.showDetail();
		System.out.println("速度"+speed);
	}
	
//	public static void main(String[] args) {
//		Random rand = new Random();
//		Vehicle car = new Car("黑色",50);
//		car.speedControl(rand.nextInt(380)+20);
//		car.showDetail();
//		
//		Vehicle ship = new Car("红色",20);
//		ship.speedControl(rand.nextInt(380)+20);
//		ship.showDetail();
//		
//		Vehicle plane = new Car("白色",200);
//		plane.speedControl(rand.nextInt(380)+20);
//		plane.showDetail();
//	}
}










