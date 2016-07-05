package usuarioJDBC;

import java.util.List;

public interface uduarioDAO {

	public List<usuarioDTO> select();
	public int update(usuarioDTO usuario);
	public int delete(usuarioDTO usuario);
	public int insert(usuarioDTO usuario);
	
}
