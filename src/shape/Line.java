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

	// methods
	@Override
	public void draw(Graphics g) {
		super.paint(g);
		g.setColor(super.getColor());
		g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
		repaint();
	}
	
	
}
