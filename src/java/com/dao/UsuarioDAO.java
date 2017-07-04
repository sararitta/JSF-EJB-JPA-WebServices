package com.dao;


import com.entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mertins
 */
@Stateless
public class UsuarioDAO implements UsuarioDAOLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario findByLogin(String login) {
        Query query = em.createNamedQuery("Usuario.findByLogin");
        try {
            Usuario usuario = (Usuario) query.setParameter("login", login).getSingleResult();
            return usuario;
        } catch (NoResultException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
