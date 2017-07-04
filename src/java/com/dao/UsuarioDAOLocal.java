package com.dao;

import com.entidades.Usuario;
import javax.ejb.Local;

/**
 *
 * @author mertins
 */
@Local
public interface UsuarioDAOLocal {

    Usuario findByLogin(String login);
}
