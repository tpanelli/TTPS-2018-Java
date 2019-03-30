package ttps.spring.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comentario_id")
	private long id;
	
	private String contenido;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id")
	private Usuario realizadoPor;
	
	
	public Comentario() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Usuario getRealizadoPor() {
		return realizadoPor;
	}
	public void setRealizadoPor(Usuario realizadoPor) {
		this.realizadoPor = realizadoPor;
	}

}
