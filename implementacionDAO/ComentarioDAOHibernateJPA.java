package ttps.spring.implementacionDAO;


import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.clasesDAO.ComentarioDAO;
import ttps.spring.entities.Comentario;

@Repository
public class ComentarioDAOHibernateJPA extends GenericDAOHibernateJPA<Comentario> implements ComentarioDAO {


	
	public ComentarioDAOHibernateJPA() {
		super(Comentario.class);
	}

	@Override
	@Transactional
	public Set<Comentario> recuperarComentarios(long publicacion_id) {
		Query consulta= this.getEntityManager().createQuery("select e from '" + getPersistentClass().getSimpleName() +"' where publicacion_id='"+publicacion_id+"' order by fecha");
		Set<Comentario> resultado = (Set<Comentario>)consulta.getResultList();
		return resultado;
	}

}
