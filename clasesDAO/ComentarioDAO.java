package ttps.spring.clasesDAO;

import java.util.Set;

import ttps.spring.entities.Comentario;

public interface ComentarioDAO extends GenericDAO<Comentario> {
	
	public Set<Comentario> recuperarComentarios(long publicacion_id);

}
