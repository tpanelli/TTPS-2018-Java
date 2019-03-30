package ttps.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ttps.spring.clasesDAO.UsuarioDAO;
import ttps.spring.entities.Usuario;

@Controller
public class TokenValidator {
	
		@Autowired
		private UsuarioDAO uDAO;
	
		public TokenValidator() {
			
		}

		private boolean validar(String token) {
			String caracteresValidacion = (token.substring(token.length() - 6, token.length()));
			return (caracteresValidacion.equals("123456"));
		}
		
		private long obtenerId(String token) {
			return Integer.parseInt(token.substring(0, token.length() - 6));
		}
		
		public boolean validarToken(String token) {
			TokenValidator validador = new TokenValidator();
			//valido el 123456
			if(!validador.validar(token)) {
				return false; 
			}
			//valido el id del usuario que pide la informacion
			long idSesion = validador.obtenerId(token);
			if (!uDAO.usuarioExiste(idSesion)) {
				return false; 
			}
			return true;
		}
		
		public boolean validarTokenDeAdministrador(String token) {
			if (this.validarToken(token)) {
				Usuario userSesion = uDAO.recuperar(this.obtenerId(token));
				if (userSesion.getPerfil().getId() == 1) {
					return true;
				}
			}
			return false;
		}
}
