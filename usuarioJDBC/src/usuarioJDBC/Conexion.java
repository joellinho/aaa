package usuarioJDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/test";
	private static String USER = "root";
	private static String PASSWORD = "root";
	private static Driver driver = null;

	public static synchronized Connection getConnection() throws Exception {
		if (driver == null) {
			Class driverClass;
			try {
				driverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) driverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (ClassNotFoundException e) {

				System.out.println("error al cargar del driver");
				e.printStackTrace();
			}

		}
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static void close(PreparedStatement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}
}
