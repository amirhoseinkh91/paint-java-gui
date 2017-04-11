package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	public static int size;
	
	// constructors
	public Line() {
	}

	public Line(int x1, int x2, int y1, int y2, Color color, int idPerson, String type) {
		super(x1, x2, y1, y2, color, idPerson, type);
	}
	
	
	 @Override
	    public boolean containShape(double px, double py) {
	        double x2 = getX2();
	        double y2 = getY2();
	        x2 -= getX1();
	        y2 -= getY1();
	        px = px - getX1();
	        py = py - getY1();
	        double v = px * x2 + py * y2;

	        double lenSq = px * px + py * py - (v * v / (x2 * x2 + y2 * y2));
	        if (lenSq < 0) {
	            lenSq = 0;
	        }

	        return (int) lenSq == 0;
	    }

	// methods
	@Override
	public void draw(Graphics g) {
		super.paint(g);
		g.setColor(super.getColor());
		g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
		repaint();
	}
	
	
}
