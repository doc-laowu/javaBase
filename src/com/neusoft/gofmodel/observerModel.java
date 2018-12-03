package com.neusoft.gofmodel;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Admin
 * time 07点56分 2018/7/25
 * description 观察者模式
 *
 */

public class observerModel {
//	public static void main(String[] args) {
//		
//		Acount acount = new Acount();
//		
//		BankCard card_1 = new BankCard("卡一");
//		BankCard card_2 = new BankCard("卡二");
//		
//		acount.Attach(card_1);
//		acount.Attach(card_2);
//		
//		acount.setMoney(100);
//		
//		acount.setMoney(20000);
//		
//	}
}

class Acount
{
	private int Money;
	
	private String AcountName;
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	public Acount(){}
	
	public void setMoney(int Money)
	{
		this.Money += Money;
		Notify(Money);
	}
	
	public int getMoney()
	{
		return Money;
	}
	
	public String getAcountNum()
	{
		return AcountName;
	}
	
	Acount(String AcountNum)
	{
		this.AcountName = AcountNum;
	}
	
	public final boolean Attach(Observer o)
	{
		return observers.add(o);
	}
	
	public final boolean Dettach(Observer o)
	{
		return observers.remove(o);
	}
	
	public final void Notify(int Money)
	{
		for(Observer o : observers)
		{
			o.update(Money, getMoney());
		}
	}
	
}

interface Observer
{
	public abstract void update(int chMoney, int totalMoney);
}


class BankCard implements Observer
{
	private String name;
	
	public BankCard(String name) 
	{
		this.name = name;
	}
	
	@Override
	public void update(int chMoney, int totalMoney)
	{
		System.out.println(name+":账户存入了"+chMoney+"账户余额为:"+totalMoney);
	}
}










