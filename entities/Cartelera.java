package ttps.spring.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cartelera implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartelera_id")
	private long id;
	
	private String tipo;
	private String nombre;
	private int anio;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="idcartelera")
	private Set<Publicacion> publicaciones;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="Cartelera_usuario", joinColumns=@JoinColumn(name="cartelera_id"), inverseJoinColumns=@JoinColumn(name="usuario_id"))
	private Set<Usuario> seguidores;
	
	public Cartelera() {
		this.publicaciones = new HashSet<Publicacion>();
		this.seguidores = new HashSet<Usuario>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public Set<Publicacion> getPublicaciones() {
		return publicaciones;
	}
	public void setPublicaciones(Set<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	public Set<Usuario> getSeguidores() {
		return seguidores;
	}
	public void setSeguidores(Set<Usuario> seguidores) {
		this.seguidores = seguidores;
	}
	
	public void agregarPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
	}

}
