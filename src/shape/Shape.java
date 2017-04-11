package shape;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Shape extends JFrame {
	private int x1, x2, y1, y2;
	private Color color;
	private int idPerson;
	private String shapeType;

	/*
	 * constructors
	 */
	public Shape() {
	}

	public Shape(int x1, int x2, int y1, int y2, Color color, int idPerson, String shapeType) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
		this.idPerson = idPerson;
		this.shapeType = shapeType;
	}

	// getter
	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public Color getColor() {
		return color;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public String getShapeType() {
		return shapeType;
	}

	// setter
	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public void setShapeType(String type) {
		this.shapeType = type;
	}

	// methods
	// draw
	public  void draw(Graphics g){
		
	}

	// set coordiantes for draw in reverse direction
	protected void setCoordinates() {
		int temp;
		int x_1 = this.x1, x_2 = this.x2;
		int y_1 = this.y1, y_2 = this.y2;

		if (x_1 > x_2) {
			temp = x_2;
			x_2 = x_1;
			x_1 = temp;

			this.x1 = x_1;
			this.x2 = x_2;
		}
		if (y_1 > y_2) {
			temp = y_2;
			y_2 = y_1;
			y_1 = temp;

			this.y1 = y_1;
			this.y2 = y_2;
		}
	}


}
