package com.neusoft.InnerClass;

import java.util.Formatter;

/**
 * 
 * @author Admin
 *	description : 这是java的字符串格式化，使用Formatter类
 *	Formatter类还可以用作字符的类型转换
 */

public class Receipt {
	
	private double total = 0;
	private Formatter f = new Formatter(System.out);
	
	public void printTittle()
	{
		f.format("%-15s %5s %10s\n", "items", "qty", "price");
		f.format("%-15s %5s %10s\n", "----", "----", "----");
	}
	
	public void print(String name, int qty, double price)
	{
		f.format("%-15.15s %5d %10.2f\n", name, qty, price);
		total += price;
	}
	
	public void printTotal()
	{
		f.format("%-15s %5s %10.2f\n", "tax", "", total*0.06);
		f.format("%-15s %5s %10.2s\n", "--", "", "-----");
		f.format("%-15s %5s %10.2f\n", "total", "", total*1.06);
	}
	
	public static void main(String[] args) {
		
		Receipt ptr = new Receipt();
		ptr.printTittle();
		ptr.print("laowu", 4, 4.25);
		ptr.print("laowu", 4, 4.25);
		ptr.printTotal();
		
	}
}
