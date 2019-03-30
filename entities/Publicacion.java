package ttps.spring.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Publicacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="publicacion_id")
	private long id;
	
	private String titulo;
	private String contenido;
	private Timestamp fecha;
	
	@ElementCollection
	private Set<String> urlArchivos;
	
	private Boolean comentariosHabilitados;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id")
	private Usuario publicador;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="idpublicacion")
	private Set<Comentario> comentarios;
	
	public Publicacion() {
		comentarios = new HashSet<Comentario>();
		urlArchivos = new HashSet<String>();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public Set<String> getUrlArchivos() {
		return urlArchivos;
	}
	public void setUrlArchivos(Set<String> urlArchivos) {
		this.urlArchivos = urlArchivos;
	}
	public Boolean getComentariosHabilitados() {
		return comentariosHabilitados;
	}
	public void setComentariosHabilitados(Boolean comentariosHabilitados) {
		this.comentariosHabilitados = comentariosHabilitados;
	}
	public Usuario getPublicador() {
		return publicador;
	}
	public void setPublicador(Usuario publicador) {
		this.publicador = publicador;
	}
	public Set<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void agregarArchivo(String url) {
		urlArchivos.add(url);
	}
	public void agregarComentario(Comentario comentario) {
		comentarios.add(comentario);
	}

}
