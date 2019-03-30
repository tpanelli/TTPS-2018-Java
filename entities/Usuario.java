package ttps.spring.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usuario_id")
	private long id;
	
	
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	
	@JsonIgnore
	@ManyToMany(mappedBy="seguidores")
	private Set<Cartelera> carteleras;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name="perfil_id")
	private Perfil perfil;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="Usuario_notificacion", joinColumns=@JoinColumn(name="usuario_id"), inverseJoinColumns=@JoinColumn(name="notificacion_id"))
	private Set<Notificacion> notificaciones;
	
	

	public Usuario() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Cartelera> getCarteleras() {
		return carteleras;
	}

	public void setCarteleras(Set<Cartelera> carteleras) {
		this.carteleras = carteleras;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public Set<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Set<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

}
