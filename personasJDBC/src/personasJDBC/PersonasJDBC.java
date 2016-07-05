package personasJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene los metodos de select ,insert,udate
 * 
 * @author aarons
 *
 */
public class PersonasJDBC {
	private final String SQL_INSERT = "insert into persona(nombre,apellido)values(?,?)";
	private final String SQL_UPDATE = "update  persona set nombre=?,apellido=? where id_persona=?";
	private final String SQL_DELETE = "delete  from persona where id_persona= ?";
	private final String SQL_SELECT = "select id_persona,nombre,apellido from persona order by id_persona ";

	public List<Persona> select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Persona persona= null;
		List<Persona> personas = new ArrayList<Persona>();
		try {
			conn = Conexion.getConnection();
			stmt = conn.createStatement();
			System.out.println("ejecucanto query " + SQL_INSERT);
			rs = stmt.executeQuery(SQL_SELECT);
			while (rs.next()) {
				
				int id_persona = rs.getInt(1);
				String nombre =rs.getString(2);
				String apellido = rs.getString(3);
				//System.out.print("id :" + rs.getInt(1)+"\t");
				//System.out.print("nombre :" + rs.getString(2)+"\t");
				//System.out.print("apellido:" + rs.getString(3)+"\n");
				persona = new Persona();
				persona.setId_persona(id_persona);
				persona.setNombre(nombre);
				persona.setApellido(apellido);
				personas.add(persona);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("fallo en la selecion de datos");
		} finally {
			Conexion.close(rs);

			Conexion.close(conn);
		}
		return personas;
	}

	public int insert(String nombre,String apellido) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int rows = 0;
		try {
			int index = 1;
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(index++, nombre);
			// System.out.println(index);
			stmt.setString(index++, apellido);
			// System.out.println(index);
			System.out.println("ejecucanto query " + SQL_INSERT);
			rows = stmt.executeUpdate();
			System.out.println("Registros Afectados :" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("fallo en la insercion de datos");
		} finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return rows;
	}

	public int update(int persona_id, String nombre, String apellido) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int index = 1;
			System.out.println("ejecucanto query " + SQL_UPDATE);
			stmt.setString(index++, nombre);
			stmt.setString(index++, apellido);
			stmt.setInt(index, persona_id);
			rows = stmt.executeUpdate();
			System.out.println("registros afectados :" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("fallo en la actualizacion de datos");
		} finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return rows;

	}

	public int delete(int id_persona) {
		Connection conn = null;
		PreparedStatement stm = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			System.out.println("ejecutando la consulta :" + SQL_DELETE);

			stm = conn.prepareStatement(SQL_DELETE);
			stm.setInt(1, id_persona);
			rows = stm.executeUpdate();
			System.out.println("columnas afectadas" + rows);
		} catch (SQLException e) {
			System.out.println("error al eliminar los datos");
			e.printStackTrace();
		} finally {
			Conexion.close(stm);
			Conexion.close(conn);
		}
		return rows;
	}

}
