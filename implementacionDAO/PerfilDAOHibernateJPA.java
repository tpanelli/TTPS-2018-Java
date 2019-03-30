package ttps.spring.implementacionDAO;



import org.springframework.stereotype.Repository;

import ttps.spring.clasesDAO.PerfilDAO;
import ttps.spring.entities.Perfil;

@Repository
public class PerfilDAOHibernateJPA extends GenericDAOHibernateJPA<Perfil> implements PerfilDAO {

	
	public PerfilDAOHibernateJPA() {
		super(Perfil.class);
	}

}
