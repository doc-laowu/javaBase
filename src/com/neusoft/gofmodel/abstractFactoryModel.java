package com.neusoft.gofmodel;

/**
 * 
 * @author Admin
 *	time : 18点17分 2018/7/26
 *	description : 抽象工厂模式
 */

public class abstractFactoryModel {
//	public static void main(String[] args) {
//		FactoryProducer.getFactory("shape").getShape("circle").draw();
//		FactoryProducer.getFactory("color").getColor("red").fill();
//	}
}

interface Shape
{
	public void draw();
}

class Circle implements Shape
{
	@Override
	public void draw()
	{
		System.out.println("Inside Circle::draw() method.");
	}
}

class Square implements Shape
{
	@Override
	public void draw()
	{
		System.out.println("Inside Square::draw() method.");
	}
}

class Rectangle implements Shape
{
	@Override
	public void draw()
	{
		System.out.println("Inside Retangle::draw() method.");
	}
}

interface Color
{
	public void fill();
}

class Red implements Color
{
	@Override
	public void fill()
	{
		System.out.println("Inside Red::fill() method.");
	}
}

class Green implements Color
{
	@Override
	public void fill()
	{
		System.out.println("Inside Green::fill() method.");
	}
}

class Blue implements Color
{
	@Override
	public void fill()
	{
		System.out.println("Inside Green::fill() method.");
	}
}

abstract class AbstractFactory 
{
	   public abstract Color getColor(String color);
	   
	   public abstract Shape getShape(String shape);
}


class ShapeFactory extends AbstractFactory 
{
	@Override
	public Shape getShape(String shapeType)
	{
		if(shapeType == null)
		{
			return null;
	    }        
	    if(shapeType.equalsIgnoreCase("CIRCLE"))
	    {
	         return new Circle();
	    } 
	    else if(shapeType.equalsIgnoreCase("RECTANGLE"))
	    {
	         return new Rectangle();
	    }
	    else if(shapeType.equalsIgnoreCase("SQUARE"))
	    {
	         return new Square();
	    }
	     
	    return null;
	}
	@Override
	public Color getColor(String color) 
	{
		return null;
	}
}



class ColorFactory extends AbstractFactory 
{
	@Override
	public Shape getShape(String shapeType)
	{
		return null;
	}
	   
	@Override
	public Color getColor(String color) 
	{
		if(color == null)
		{
		     return null;
		}        
		if(color.equalsIgnoreCase("RED"))
		{
			  return new Red();
		} 
		else if(color.equalsIgnoreCase("GREEN"))
		{
			  return new Green();
		} 
		else if(color.equalsIgnoreCase("BLUE")) 
		{
			  return new Blue();
		}	
		else
		{
			  return null;
		}
	}
}

class FactoryProducer 
{
	public static AbstractFactory getFactory(String choice)
	{
		if(choice.equalsIgnoreCase("SHAPE"))
		{
	     
			return new ShapeFactory();
	  
		} 
	    else if(choice.equalsIgnoreCase("COLOR"))
	    {
	    
	    	return new ColorFactory();
	    }
	  
	    return null;
	}
}

















