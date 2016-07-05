package usuarioJDBC;

public class usuarioDTO {
	private int id_usuario;
	private String uduario;
	private String password;
	
	public usuarioDTO(){}
	
	public usuarioDTO(int id_usuario){
		this.id_usuario = id_usuario;
		
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUduario() {
		return uduario;
	}

	public void setUduario(String usuario) {
		this.uduario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	 
}
