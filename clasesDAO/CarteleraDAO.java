package ttps.spring.clasesDAO;

import java.util.Set;

import ttps.spring.entities.Cartelera;

public interface CarteleraDAO extends GenericDAO<Cartelera> {
	
	public Set<Cartelera> recuperarCartelerasDeAnio(int anio);
	public Set<Cartelera> recuperarCartelerasDeTipo(String tipo);
	public Cartelera recuperar(String nombre);
	public boolean carteleraExiste(Cartelera cartelera);
}
