package ttps.spring.implementacionDAO;

import java.util.Set;

import javax.persistence.Query;

import ttps.spring.clasesDAO.PublicacionDAO;
import ttps.spring.entities.Publicacion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PublicacionDAOHibernateJPA extends GenericDAOHibernateJPA<Publicacion> implements PublicacionDAO {

	
	
	public PublicacionDAOHibernateJPA() {
		super(Publicacion.class);
	}

	@Override
	@Transactional
	public Set<Publicacion> recuperarPublicacionesOrdenadasPorFecha(long cartelera_id) {
		Query consulta= this.getEntityManager().createQuery("select e from '" + getPersistentClass().getSimpleName() +"' where cartelera_id='"+cartelera_id+"' order by fecha");
		Set<Publicacion> resultado = (Set<Publicacion>)consulta.getResultList();
		return resultado;
	}

}
