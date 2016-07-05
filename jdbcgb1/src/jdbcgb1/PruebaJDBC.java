package jdbcgb1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class PruebaJDBC {
	public static String url = "jdbc:mysql://localhost:3306/test";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion = DriverManager.getConnection(url, "root", "root");
 
			Statement instruccion = conexion.createStatement();

			String sql = "select * from persona";

			ResultSet result = instruccion.executeQuery(sql);

			System.out.println("|" + "id" + "\t" + "nombre" + "\t" + "apellidos" + "|");
			while (result.next()) {

				System.out.println(" "+result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3));

			}

			result.close();
			instruccion.close();
			conexion.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
