package ttps.spring.implementacionDAO;


import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.clasesDAO.CarteleraDAO;
import ttps.spring.entities.Cartelera;


@Repository
public class CarteleraDAOHibernateJPA extends GenericDAOHibernateJPA<Cartelera> implements CarteleraDAO {

	
	
	public CarteleraDAOHibernateJPA() {
		super(Cartelera.class);
	}

	@Override
	@Transactional
	public Set<Cartelera> recuperarCartelerasDeAnio(int anio) {
		Query consulta= this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() +" where anio = "+anio);
		Set<Cartelera> resultado = (Set<Cartelera>)consulta.getResultList();
		return resultado;
	}

	@Override
	@Transactional
	public Set<Cartelera> recuperarCartelerasDeTipo(String tipo) {
		Query consulta= this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() +" where tipo = '"+tipo+"'");
		Set<Cartelera> resultado = (Set<Cartelera>)consulta.getResultList();
		return resultado;
	}

	@Override
	@Transactional
	public Cartelera recuperar(String nombre) {
		Query consulta= this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() +" where nombre ='"+nombre+"'");
		List<Cartelera> resultado = (List<Cartelera>)consulta.getResultList();
		if (resultado.isEmpty()) {
			return null;
		}
		return resultado.get(0);
	}
	
	@Override
	@Transactional
	public boolean carteleraExiste(Cartelera cartelera) {
		Cartelera entity = this.recuperar(cartelera.getNombre());
		if (entity != null) {
			return true;
		}
		return false;
	}
	

}
