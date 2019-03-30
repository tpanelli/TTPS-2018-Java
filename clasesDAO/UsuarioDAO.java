package ttps.spring.clasesDAO;

import ttps.spring.entities.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public Usuario buscarLogin(String username, String password);
	
	public Usuario recuperar(String username);
	
	public boolean usuarioExiste(Usuario user);
	
	public boolean usuarioExiste(long id);
	
}
