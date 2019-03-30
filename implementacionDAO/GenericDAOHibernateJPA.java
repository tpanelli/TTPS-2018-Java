package ttps.spring.implementacionDAO;

import java.io.Serializable;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import org.springframework.transaction.annotation.Transactional;

import ttps.spring.clasesDAO.GenericDAO;



public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
	
	
	@PersistenceContext
    private EntityManager entityManager;
	 
    
	public void setEntityManager(EntityManager em){
    		this.entityManager = em;
	}
    
	public EntityManager getEntityManager() {
		 return entityManager;
	}


	protected Class<T> persistentClass;
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	public GenericDAOHibernateJPA(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}


	@Override
	@Transactional
	public T actualizar(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}
	

	@Override
	@Transactional
	public void borrar(T entity) {
		EntityManager em = this.getEntityManager();
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}
		

	

	@Override
	@Transactional
	public T borrar(Serializable id) {
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
			this.borrar(entity);
		}
		return entity;
	} 
	

	@Override
	@Transactional
	public boolean existe(Serializable id) {
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public T persistir(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}

	@Override
	@Transactional
	public T recuperar(Serializable id) {
		Query consulta= this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() + " where id='"+id+"'");
		List<T> resultado = (List<T>)consulta.getResultList();
		if (resultado.isEmpty()) {
			return null;
		}
		return resultado.get(0);
	}
	
	@Override
	@Transactional
	public List<T> recuperarTodos() {
		Query consulta= this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName());
		List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}

}
