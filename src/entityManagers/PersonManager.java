package entityManagers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Person.Person;

public class PersonManager {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Paint";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "David021 Erfan";

	// ==============================================
	/*
	 * addPerson
	 */
	public static void addPerson(Person p) {

		Connection conn = null;
		Statement stmt = null;

		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			String username = p.getUsername();
			String password = p.getPassword();

			
			// check if user exists or not!
			 int id = searchPerson(username, password);
			 if (id >= 0) {
				 // can not add! already Exist
			 } else { // user does not exist
				 // do no
			String sql = "INSERT INTO Paint.Persons (username, password) VALUES ('" + username + "','" + password
					+ "');";
			stmt.executeUpdate(sql);
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

	}// end addPerson

	// ===============================================
	/*
	 * searchPerson
	 */
	private static int searchPerson(String username, String password) {
		Connection conn = null;
		Statement stmt = null;
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();
			String sql = "SELECT idPerson FROM Paint.Persons WHERE username = '" + username + "' and password = '"
					+ password + "';";
			ResultSet rs = stmt.executeQuery(sql);

			int idPerson = -1;
			while (rs.next()) {
				idPerson = rs.getInt("idPerson");
			}

			rs.close();

			return idPerson;

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
		return -1;

	}// end getStudent

	// ================================================
	/*
	 * loginPerson
	 */
	public static int login(String username, String password) {
		return searchPerson(username, password);
	} // end login
}
