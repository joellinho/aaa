package personasJDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private static String JDBC_URL = "jdbc:mysql://localhost/test";
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_USER = "root";
	private static String JDBC_PASS = "root";
	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException {
		if (driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);

			} catch (Exception e) {
				System.out.println("fallo el driver de la conexion");
				e.printStackTrace();

			}

		}

		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	public static void close(PreparedStatement stmt) {
		try {
			if (stmt != null)
				stmt.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

}
