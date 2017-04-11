package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	public static int size;

	// constructors
	public Rectangle() {
	}

	public Rectangle(int x1, int x2, int y1, int y2, Color color, int idPerson, String type) {
		super(x1, x2, y1, y2, color, idPerson, type);
	}

	@Override
	public boolean containShape(double x, double y) {

		int x1 = getX1();
		int y1 = getY1();
		int x2 = getX2();
		int y2 = getY2();

		return (((x >= (x1 - 1)) && (x <= (x1 + 1))) || ((x >= (x2 - 1)) && (x <= (x2 + 1)))
				|| ((y >= (y1 - 1)) && (y <= (y1 + 1))) || ((y >= (y2 - 1)) && (y <= (y2 + 1))));
	}

	// methods
	@Override
	public void draw(Graphics g) {
		setCoordinates();
		g.setColor(super.getColor());
		g.drawRect(super.getX1(), super.getY1(), width(), height());
	}

	public int width() {
		return super.getX2() - super.getX1();
	}

	public int height() {
		return super.getY2() - super.getY1();
	}
}
