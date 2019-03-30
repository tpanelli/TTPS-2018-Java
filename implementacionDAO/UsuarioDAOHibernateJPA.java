package ttps.spring.implementacionDAO;






import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.clasesDAO.UsuarioDAO;
import ttps.spring.entities.Usuario;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
	

	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}


	@Override
	@Transactional
	public Usuario buscarLogin(String username, String password) {
		Query consulta= this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() +" where username='"+username+"' and password='"+ password +"'");
		List<Usuario> resultado = (List<Usuario>)consulta.getResultList();
		if (resultado.isEmpty()) {
			return null;
		}
		return resultado.get(0);
	}
	
	@Override
	@Transactional
	public Usuario recuperar(String username) {
		Query consulta= this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() + " where username='"+username+"'");
		List<Usuario> resultado = (List<Usuario>)consulta.getResultList();
		if (resultado.isEmpty()) {
			return null;
		}
		return resultado.get(0);
	}
	
	@Override
	@Transactional
	public boolean usuarioExiste(Usuario user) {
		Usuario entity = this.recuperar(user.getUsername());
		if (entity != null) {
			return true;
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean usuarioExiste(long id) {
		Usuario entity = this.recuperar(id);
		if (entity != null) {
			return true;
		}
		return false;
	}

}
