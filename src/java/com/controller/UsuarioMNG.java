package com.controller;

import com.dao.UsuarioDAOLocal;
import com.entidades.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mertins
 */
@Named(value = "usuarioMNG")
@RequestScoped

public class UsuarioMNG implements Serializable {

    public static final String USER_SESSION_KEY = "sessaousuario";
    @EJB
    UsuarioDAOLocal dao;
    private String login;
    private String senha;

    /**
     * Creates a new instance of UsuarioMNG
     */
    public UsuarioMNG() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String valida() {
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario usuario = dao.findByLogin(login);
        if (usuario != null) {
            if (!usuario.getSenha().equals(senha)) {
                this.msgInvalidLogin(context);
                return null;
            }
            context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, usuario);
            return "formprincipal";
        } else {
            this.msgInvalidLogin(context);
            return null;
        }
    }

    private void msgInvalidLogin(FacesContext context) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na autenticação!", "Usuário ou senha inválidos");
        context.addMessage(null, message);
    }
}
