package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	
	/**
	 * 
	 */
	public static int size;
	
	// constructors
	public Circle() {
	}

	public Circle(int x1, int x2, int y1, int y2, Color color, int idPerson, String type) {
		super(x1, x2, y1, y2, color, idPerson, type);
	}
	
	
	// methods
	@Override
	public void draw(Graphics g) {
		setCoordinates();
		g.setColor(super.getColor());
		g.drawOval(super.getX1(), super.getY1(), width(), height());
	}

	public int width(){
		return super.getX2() - super.getX1();
	}
	
	public int height(){
		return super.getY2() - super.getY1();
	}
	
	
}
