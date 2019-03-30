package ttps.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ttps.spring.clasesDAO.CarteleraDAO;
import ttps.spring.entities.Cartelera;

@CrossOrigin
@RestController
public class CarteleraRestController {
	
	@Autowired
	private CarteleraDAO cDAO;
	
	@Autowired
	private TokenValidator validador;
	
	//Obtener todas las carteleras
	
	@RequestMapping(value = "/carteleras", method = RequestMethod.GET)
	public ResponseEntity<List<Cartelera>> listAllCarteleras(@RequestHeader("token") String token) {
		if (!validador.validarToken(token)){
			return new ResponseEntity<List<Cartelera>>(HttpStatus.UNAUTHORIZED);
		}
		List<Cartelera> carteleras = cDAO.recuperarTodos();
		if(carteleras.isEmpty()){
			return new
			ResponseEntity<List<Cartelera>>(HttpStatus.NO_CONTENT);
		}
	    return new ResponseEntity<List<Cartelera>>(carteleras, HttpStatus.OK);
	}
	
	//Dar de alta una cartelera
	
	@RequestMapping(value = "/carteleras", method = RequestMethod.POST, consumes= "application/json")
	public ResponseEntity<Void> crearCartelera(@RequestBody Cartelera cartelera, 
			@RequestHeader("token") String token){
		if (!validador.validarTokenDeAdministrador(token)){
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		System.out.println("Creando la cartelera " + cartelera.getNombre());
		if (cDAO.carteleraExiste(cartelera)) {
			System.out.println("Ya existe una cartelera con nombre " + cartelera.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		}
		else {
			cDAO.persistir(cartelera);
			System.out.println("Se creo la cartelera " + cartelera.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}

	}

}
