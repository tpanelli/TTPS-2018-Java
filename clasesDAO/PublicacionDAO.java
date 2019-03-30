package ttps.spring.clasesDAO;

import java.util.Set;

import ttps.spring.entities.Publicacion;

public interface PublicacionDAO extends GenericDAO<Publicacion> {
		
	public Set<Publicacion> recuperarPublicacionesOrdenadasPorFecha(long cartelera_id);
	
}
