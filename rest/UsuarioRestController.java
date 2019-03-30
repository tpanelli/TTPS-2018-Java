package ttps.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ttps.spring.clasesDAO.UsuarioDAO;
import ttps.spring.entities.Usuario;

@CrossOrigin
@RestController
public class UsuarioRestController {

	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private TokenValidator validador;
	
	//Crear usuario
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.POST, consumes= "application/json")
	public ResponseEntity<Void> crearUsuario(@RequestBody Usuario user, UriComponentsBuilder ucBuilder){
		System.out.println("Creando el usuario " + user.getUsername());
		if (uDAO.usuarioExiste(user)) {
			System.out.println("Ya existe un usuario con nombre " + user.getUsername());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		}
		else {
			uDAO.persistir(user);
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	        System.out.println("Se creo el usuario " + user.getUsername());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

	}
	
	
	//Obtener usuarios
	
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> obtenerUsuarios(){
		List<Usuario> users = uDAO.recuperarTodos();
		if(users.isEmpty()){
			return new
			ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
	    return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);

	}
	
	//Obtener usuario especifico FALTA TOKEN
	
	
		@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
		public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("id") long id, 
															@RequestHeader("token") String token){
			
			if (!validador.validarToken(token)){
				return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
			}
			Usuario user = uDAO.recuperar(id);
			if(user == null){
				return new
				ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
			}
		    return new ResponseEntity<Usuario>(user, HttpStatus.OK);

		}
	
	//Autenticar usuario
	
		@RequestMapping(value = "/autenticacion", method = RequestMethod.POST, consumes= "application/json")
		public ResponseEntity<Usuario> autenticarUsuario(@RequestHeader("username") String username, 
			@RequestHeader("password") String password){
				Usuario user = uDAO.buscarLogin(username, password);
				if(user == null) {
					return new ResponseEntity<Usuario>(HttpStatus.FORBIDDEN);
				} else {
					HttpHeaders headers = new HttpHeaders();
					String token = String.valueOf(user.getId()) + "123456";
			        headers.add("token", token);
			        headers.add("Access-Control-Expose-Headers", "token");
					return new ResponseEntity<Usuario>(user,headers, HttpStatus.OK);
				}
			
		}
		
		//Actualizar usuario FALTA TOKEN
		
		
			@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT)
			public ResponseEntity<Void> actualizarUsuario(@PathVariable("id") long id, 
															@RequestBody Usuario user, 
															@RequestHeader("token") String token){
				
				if (!validador.validarToken(token)) {
					return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
				}
				if(!uDAO.usuarioExiste(id)){
					return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				}
				else {
					uDAO.actualizar(user);
					return new ResponseEntity<Void>(HttpStatus.OK);
				}

			}
			
		
	
}
