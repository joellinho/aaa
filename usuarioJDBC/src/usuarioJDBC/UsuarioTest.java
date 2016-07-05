package usuarioJDBC;

import java.util.List;

public class UsuarioTest {

	public static void main(String[] args) {
		
		JDBCusuarioImpl usuariodao = new JDBCusuarioImpl();
		usuarioDTO usuario = new usuarioDTO();
		// listar usuarios
		//List<usuarioDTO> usuarioDTO =usuariodao.select();
		
		//eliminar usuarios
		//usuario.setId_usuario(3);			
		//usuariodao.delete(usuario);
		
		//insertar usuario
		//usuario.setUduario("joel");
		//usuario.setPassword("jelinho");
		//usuariodao.insert(usuario);
	
		//actualizar datos
		usuario.setId_usuario(1);
		usuario.setUduario("joeljar");
		usuario.setPassword("passwod");
		usuariodao.update(usuario);
		
		//listarusuarios
		List<usuarioDTO> usuarioDTO =usuariodao.select();
		for (usuarioDTO usuarioDTO2 : usuarioDTO) {
			System.out.print(usuarioDTO2.getId_usuario()+"\t"+usuarioDTO2.getUduario()+"\t"+usuarioDTO2.getPassword()+"\n");
		}
	}

}
