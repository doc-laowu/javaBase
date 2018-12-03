package com.neusoft.javaClass;

public class polyConstructors {
	
}

class Glyph
{
	void draw()
	{
		System.out.println("Glyph.draw()");
	}
	Glyph()
	{
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() after draw()");
	}

}

class RoundGlyph extends Glyph
{
	private int radius = 1;
	RoundGlyph(int r)
	{
		radius = r;
		System.out.println("RoundGlyph Constractor:");
	}
	void draw()
	{
		System.out.println("RoundGlyph.draw()"+radius);
	}
}