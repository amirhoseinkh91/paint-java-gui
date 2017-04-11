package entityManagers;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import shape.*;

public class ShapeManager {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Paint";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "amir";

	// ==============================================
	/*
	 * addLine
	 */
	public static void addLine(Line l) {

		Connection conn = null;
		Statement stmt = null;

		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			String shapeType = l.getShapeType();
			String color = colorToString(l.getColor());
			int x1 = l.getX1();
			int x2 = l.getX2();
			int y1 = l.getY1();
			int y2 = l.getY2();
			int idPerson = l.getIdPerson();

			String sql = "INSERT INTO Paint.Shapes (idPerson, shapeType, x1, x2, y1, y2, color) VALUES (" + idPerson
					+ ",'" + shapeType + "'," + x1 + "," + x2 + "," + y1 + "," + y2 + ",'" + color + "');";
			stmt.executeUpdate(sql);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}// end addLine

	// ==============================================
	/*
	 * change color
	 */
	public static void changeColor(int idPerson, Shape shape) {
		Connection conn = null;
		Statement stmt = null;
		
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			String sql = "UPDATE `Paint`.`Shapes` SET `Shapes.color`='" + colorToString(shape.getColor()) + "' WHERE "
					+ " `x1` = '" + shape.getX1() + "' AND `y1` = '" + shape.getY1() + "' AND `x2` = '"
					+ shape.getX2() + "' AND `y2` = '" + shape.getY2() + "' AND `shapeType` = '" + shape.getType() + "';";
			
			
//			UPDATE `Paint`.`Shapes` SET `color`='Blue' WHERE `idShapes`='868';
			stmt.executeUpdate(sql);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try


	}// end changeColor

	

	// ==============================================
	/*
	 * addCircle
	 */
	public static void addCircle(Circle c) {

		Connection conn = null;
		Statement stmt = null;

		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			String shapeType = c.getShapeType();
			String color = colorToString(c.getColor());
			int x1 = c.getX1();
			int x2 = c.getX2();
			int y1 = c.getY1();
			int y2 = c.getY2();
			int idPerson = c.getIdPerson();

			String sql = "INSERT INTO Paint.Shapes (idPerson, shapeType, x1, x2, y1, y2, color) VALUES (" + idPerson
					+ ",'" + shapeType + "'," + x1 + "," + x2 + "," + y1 + "," + y2 + ",'" + color + "');";

			stmt.executeUpdate(sql);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}// end addCircle

	// =============================================
	/*
	 * addRectangle
	 */
	public static void addRectangle(Rectangle r) {

		Connection conn = null;
		Statement stmt = null;

		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			String shapeType = r.getShapeType();
			String color = colorToString(r.getColor());
			int x1 = r.getX1();
			int x2 = r.getX2();
			int y1 = r.getY1();
			int y2 = r.getY2();
			int idPerson = r.getIdPerson();

			String sql = "INSERT INTO Paint.Shapes (idPerson, shapeType, x1, x2, y1, y2, color) VALUES (" + idPerson
					+ ",'" + shapeType + "'," + x1 + "," + x2 + "," + y1 + "," + y2 + ",'" + color + "');";

			stmt.executeUpdate(sql);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}// end addRectangle

	// ==================================
	/*
	 * getAllRectangles
	 */
	public static Rectangle[] getAllRectangles(int idPerson) {
		Connection conn = null;
		Statement stmt = null;
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			// get all rectangles
			String sql = "SELECT * FROM Paint.Shapes WHERE Shapes.idPerson = " + idPerson
					+ " and Shapes.shapeType = 'Rectangle';";
			ResultSet rs = stmt.executeQuery(sql);

			int counter = 0;
			while (rs.next()) {
				counter++;
			}
			rs.close();
			Rectangle.size = counter;
			// System.out.println(Rectangle.size);
			Rectangle[] rectangles = new Rectangle[counter];

			sql = "SELECT shapeType, x1, x2, y1, y2, color FROM Paint.Shapes WHERE Shapes.idPerson = " + idPerson
					+ " and Shapes.shapeType = 'Rectangle';";
			ResultSet rs2 = stmt.executeQuery(sql);
			int i = 0;
			while (rs2.next()) {
				String shapeType = rs2.getString("shapeType");
				int x1 = rs2.getInt("x1");
				int x2 = rs2.getInt("x2");
				int y1 = rs2.getInt("y1");
				int y2 = rs2.getInt("y2");
				Color color = stringToColor(rs2.getString("color"));

				rectangles[i] = new Rectangle(x1, x2, y1, y2, color, idPerson, shapeType);

				i++;
			}

			rs.close();
			return rectangles;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try
		return null;

	}// end getAllRectangles

	// ==================================
	/*
	 * getAllCircles
	 */
	public static Circle[] getAllCircles(int idPerson) {
		Connection conn = null;
		Statement stmt = null;
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			// get all rectangles
			String sql = "SELECT * FROM Paint.Shapes WHERE Shapes.idPerson = " + idPerson
					+ " and Shapes.shapeType = 'Circle';";
			ResultSet rs = stmt.executeQuery(sql);

			int counter = 0;
			while (rs.next()) {
				counter++;
			}
			rs.close();
			Circle.size = counter;
			Circle[] circles = new Circle[counter];

			sql = "SELECT shapeType, x1, x2, y1, y2, color FROM Paint.Shapes WHERE Shapes.idPerson = " + idPerson
					+ " and Shapes.shapeType = 'Circle';";
			ResultSet rs2 = stmt.executeQuery(sql);
			int i = 0;
			while (rs2.next()) {
				String shapeType = rs2.getString("shapeType");
				int x1 = rs2.getInt("x1");
				int x2 = rs2.getInt("x2");
				int y1 = rs2.getInt("y1");
				int y2 = rs2.getInt("y2");
				Color color = stringToColor(rs2.getString("color"));

				circles[i] = new Circle(x1, x2, y1, y2, color, idPerson, shapeType);

				i++;
			}

			rs2.close();
			return circles;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try
		return null;

	}// end getAllCircles

	// ==================================
	/*
	 * getAllLines
	 */
	public static Line[] getAllLines(int idPerson) {
		Connection conn = null;
		Statement stmt = null;
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			// get all rectangles
			String sql = "SELECT * FROM Paint.Shapes WHERE Shapes.idPerson = " + idPerson
					+ " and Shapes.shapeType = 'Line';";
			ResultSet rs = stmt.executeQuery(sql);

			int counter = 0;
			while (rs.next()) {
				counter++;
			}
			rs.close();
			Line.size = counter;
			Line[] lines = new Line[counter];

			sql = "SELECT shapeType, x1, x2, y1, y2, color FROM Paint.Shapes WHERE Shapes.idPerson = " + idPerson
					+ " and Shapes.shapeType = 'Line';";
			ResultSet rs2 = stmt.executeQuery(sql);
			int i = 0;
			while (rs2.next()) {
				String shapeType = rs2.getString("shapeType");
				int x1 = rs2.getInt("x1");
				int x2 = rs2.getInt("x2");
				int y1 = rs2.getInt("y1");
				int y2 = rs2.getInt("y2");
				Color color = stringToColor(rs2.getString("color"));

				lines[i] = new Line(x1, x2, y1, y2, color, idPerson, shapeType);

				i++;
			}

			rs.close();
			return lines;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try
		return null;

	}// end getAllLines

	// deletes all shapes of a person
	public static void deleteAllShapes(int idPerson) {
		Connection conn = null;
		Statement stmt = null;
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			stmt.executeUpdate("delete from Paint.Shapes where idPerson=" + idPerson + ";");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	// returns shapes selected

	public static List<Shape> searchSelected(int x1, int y1, int x2, int y2, int idPerson) {
		List<Shape> shapes = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();
			String sql = "SELECT * FROM Paint.Shapes WHERE " + x1 + "<x1 AND " + x2 + ">x2 AND " + y1 + "<y1 AND " + y2
					+ ">y2 AND Shapes.idPerson = " + idPerson + ";";

			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String shapeType = rs.getString("shapeType");
				x1 = rs.getInt("x1");
				x2 = rs.getInt("x2");
				y1 = rs.getInt("y1");
				y2 = rs.getInt("y2");
				Color color = stringToColor(rs.getString("color"));
				Shape shape = new Shape(x1, x2, y1, y2, color, idPerson, shapeType);
				shapes.add(shape);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return shapes;
	}

	// change type of variables from String to Color
	static private Color stringToColor(String color) {
		Color shapeColor = Color.black;
		if (color.equals("Black")) {
			shapeColor = Color.BLACK;
		} else if (color.equals("Red")) {
			shapeColor = Color.RED;
		} else if (color.equals("Green")) {
			shapeColor = Color.GREEN;
		} else if (color.equals("Blue")) {
			shapeColor = Color.BLUE;
		}
		return shapeColor;
	}

	// change type of variables from Color to String
	static private String colorToString(Color color) {
		String shapeColor = "Black";
		if (Color.BLACK.equals(color)) {
			shapeColor = "Black";
		} else if (Color.RED.equals(color)) {
			shapeColor = "Red";
		} else if (Color.GREEN.equals(color)) {
			shapeColor = "Green";
		} else if (Color.BLUE.equals(color)) {
			shapeColor = "Blue";
		}
		return shapeColor;
	}

}
