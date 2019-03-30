package ttps.spring.implementacionDAO;

import ttps.spring.clasesDAO.*;

public class FactoryDAO {

		public static CarteleraDAO getCarteleraDAO() {
			return new CarteleraDAOHibernateJPA();
		}
		public static PublicacionDAO getPublicacionDAO() {
			return new PublicacionDAOHibernateJPA();
		}
		public static ComentarioDAO getComentarioDAO() {
			return new ComentarioDAOHibernateJPA();
		}
		public static UsuarioDAO getUsuarioDAO() {
			return new UsuarioDAOHibernateJPA();
		}
		public static PerfilDAO getPerfilDAO() {
			return new PerfilDAOHibernateJPA();
		}
}
