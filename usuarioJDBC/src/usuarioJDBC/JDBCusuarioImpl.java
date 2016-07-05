package usuarioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCusuarioImpl implements uduarioDAO {
	private static String JDBC_SELECT = "select * from usuarios";
	private static String JDBC_INSERT = "insert into usuarios (usuario,password)values(?,?)";
	private static String JDBC_UPDATE = "update  usuarios set usuario=?,password=? where id_usuario=?";
	private static String JDBC_DELETE = "delete from usuarios where id_usuario =? ";

	@Override
	public List<usuarioDTO> select() {

		List<usuarioDTO> lista = new ArrayList<usuarioDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		usuarioDTO user = null;
		try {
			conn = Conexion.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(JDBC_SELECT);
			while (rs.next()) {
				int id_usuario = rs.getInt(1);
				String usuario = rs.getString(2);
				String password = rs.getString(3);
				// System.out.println(id_usuario);
				// System.out.println(usuario);
				// System.out.println(password);
				user = new usuarioDTO();
				user.setId_usuario(id_usuario);
				user.setUduario(usuario);
				user.setPassword(password);
				lista.add(user);
			}

		} catch (Exception e) {
			System.out.println("error al insertar los datos");
			e.printStackTrace();
		} finally {
			Conexion.close(rs);
			Conexion.close(conn);
		}
		return lista;
	}

	@Override
	public int update(usuarioDTO usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;

		int rows = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(JDBC_UPDATE);
			stmt.setInt(3, usuario.getId_usuario());
			stmt.setString(1, usuario.getUduario());
			stmt.setString(2, usuario.getPassword());

			rows = stmt.executeUpdate();
			System.out.println("registros afectados :" + rows);
		} catch (Exception e) {
			System.out.println("error al actualizar los datos");
			e.printStackTrace();

		} finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return rows;
	}

	@Override
	public int delete(usuarioDTO usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(JDBC_DELETE);
			stmt.setInt(1,usuario.getId_usuario());

			rows = stmt.executeUpdate();
			System.out.println("registros afectados" + rows);
		} catch (Exception e) {
			System.out.println("error en la insercion de datos");
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return rows;
	}

	@Override
	public int insert(usuarioDTO usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(JDBC_INSERT);
			stmt.setString(1, usuario.getUduario());
			stmt.setString(2, usuario.getPassword());
			rows = stmt.executeUpdate();
			System.out.println("registros afectados" + rows);
		} catch (Exception e) {
			System.out.println("error en la insercion de datos");
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}

		return rows;
	}

}
