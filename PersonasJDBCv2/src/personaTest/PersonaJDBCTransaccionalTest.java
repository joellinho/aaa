package personaTest;

import java.sql.Connection;
import java.sql.SQLException;

import personasJDBC.Conexion;
import personasJDBC.PersonasJDBC;

public class PersonaJDBCTransaccionalTest {

	public static void main(String[] args) {
		Connection conn= null;
		try {
			conn = Conexion.getConnection();
			if(conn.getAutoCommit()){
				conn.setAutoCommit(false);
			
			}
			PersonasJDBC personas = new PersonasJDBC(conn);
			personas.insert("joel","heraud");
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("estamos haciendo rollbak");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
