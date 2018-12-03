package com.neusoft.javaClass;

public class hanuoTower {
	
	public static void main(String[] args) {
		hanuoTower ptr = new hanuoTower();
		ptr.hanuo(5, 'a', 'b', 'c');
	}
	
	void move(int i, char m, char n)
	{
		System.out.println("第"+i+"个：从"+m+"移动到"+n);
	}
	
	void hanuo(int n, char a, char b, char c)
	{
		if(1 == n)
		{
			move(n, a, c);
		}
		else
		{
			hanuo(n-1, a, c, b);
			move(n, a, c);
			hanuo(n-1, b, a, c);
		}
	}
}
