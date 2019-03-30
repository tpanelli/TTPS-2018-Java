package ttps.spring.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="perfil_id")
	private long id;
	
	private String tipo;
	
	public Perfil() {
		
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
	

}
