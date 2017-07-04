/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.UsuarioDAOLocal;
import com.entidades.Usuario;
import com.ucpel.wscorreios.CResultado;
import com.ucpel.wscorreios.CalcPrecoPrazoWS;
import com.ucpel.wscorreios.CalcPrecoPrazoWSSoap;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.swing.JOptionPane;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "login")
public class LoginController implements Serializable {

    public static final String USER_SESSION_KEY = "sessaousuario";
    @EJB
    UsuarioDAOLocal dao;
    private String login;
    private String senha;
    private String valorEntrega;
    boolean loggedIn;
    private String teste;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public String getValorEntrega() {
        return valorEntrega;
    }

    public void setValorEntrega(String valorEntrega) {
        this.valorEntrega = valorEntrega;
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

    public void loginCentral(ActionEvent event) throws IOException {

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        Usuario usuario = dao.findByLogin(login);
        if (usuario.getSenha().equals(senha)) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo", login);
            FacesContext.getCurrentInstance().getExternalContext().redirect("formprincipal.jsf");
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro Login", "Usuario ou senha invalido");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }
    
    public void consultaOSLogoff(ActionEvent event) throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext.getCurrentInstance().getExternalContext().redirect("consultaOSLogoff.jsf");
    }

    public void sair() throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if (loggedIn == false) {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Você saiu", login);
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    public void consultaOS(ActionEvent event) throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext.getCurrentInstance().getExternalContext().redirect("consultaOS.jsf");
    }

    public void cadastrarOS(ActionEvent event) throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext.getCurrentInstance().getExternalContext().redirect("cadastrarOS.jsf");
    }

    public void cadastrarCliente(ActionEvent event) throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext.getCurrentInstance().getExternalContext().redirect("cadCliente.jsf");
    }

    public void consultaCliente(ActionEvent event) throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext.getCurrentInstance().getExternalContext().redirect("formcliente.jsf");
    }

    public String consultaCEP(ActionEvent event) throws IOException {
         RequestContext context = RequestContext.getCurrentInstance();
        CResultado calcPreco = CalcPreco("", "", "41106", msg, "96040050", "1", 1, new BigDecimal(20), new BigDecimal(20), new BigDecimal(20), new BigDecimal(20), "S", new BigDecimal(20), "N");
        this.valorEntrega = calcPreco.getServicos().getCServico().get(0).getValorSemAdicionais();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "O valor do frete é: ", this.valorEntrega));
        return valorEntrega;
    }

    public String teste(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        System.out.println(teste);
        return teste;
    }

    private static CResultado CalcPreco(java.lang.String nCdEmpresa, java.lang.String sDsSenha, java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String nVlPeso, int nCdFormato, java.math.BigDecimal nVlComprimento, java.math.BigDecimal nVlAltura, java.math.BigDecimal nVlLargura, java.math.BigDecimal nVlDiametro, java.lang.String sCdMaoPropria, java.math.BigDecimal nVlValorDeclarado, java.lang.String sCdAvisoRecebimento) {
        CalcPrecoPrazoWS service = new CalcPrecoPrazoWS();
        CalcPrecoPrazoWSSoap port = service.getCalcPrecoPrazoWSSoap();
        return port.calcPreco(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);
    }
}
