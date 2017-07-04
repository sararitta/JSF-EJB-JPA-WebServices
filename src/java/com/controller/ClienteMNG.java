/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.CadastroosDAOLocal;
import com.dao.ClienteDAOLocal;
import com.entidades.Cadastroos;
import com.entidades.Cliente;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.validation.constraints.Pattern;

/**
 *
 * @author sara
 */
@Named(value = "clienteMNG")
@RequestScoped
public class ClienteMNG implements Serializable{

    @EJB
    ClienteDAOLocal dao;
    private String codigo;
    private String nome;
    private String sobrenome;
    private Date dtNascimento;
    private String endereco;
    private String contatoCel;
    private String contatoFixo;
    private int codOS;

    public ClienteMNG() {
    }

    public ClienteDAOLocal getDao() {
        return dao;
    }

    public void setDao(ClienteDAOLocal dao) {
        this.dao = dao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContatoCel() {
        return contatoCel;
    }

    public void setContatoCel(String contatoCel) {
        this.contatoCel = contatoCel;
    }

    public String getContatoFixo() {
        return contatoFixo;
    }

    public void setContatoFixo(String contatoFixo) {
        this.contatoFixo = contatoFixo;
    }

    public int getCodOS() {
        return codOS;
    }

    public void setCodOS(int codOS) {
        this.codOS = codOS;
    }

    public List<Cliente> getLista() {
        return dao.listaTodos();
    }

    public void clear(AjaxBehaviorEvent event) {
        this.codigo = null;
        this.nome = null;
    }

    public String save() {

        Cliente dept = new Cliente();
        dept.setCod(codOS);
        dept.setNome(nome);
        dept.setSobrenome(sobrenome);
        dept.setDtnascimento(dtNascimento);
        dept.setEndereco(endereco);
        dept.setContatocel(contatoCel);
        dept.setContatofixo(contatoFixo);
        dao.create(dept);
        return "index";
    }
    
    public void retrieve() {
        Cliente dept = new Cliente();

        dept.getCod();
        dept.getNome();
        dept.getSobrenome();
        dept.getDtnascimento();
        dept.getEndereco();
        dept.getContatocel();
        dept.getContatofixo();
        dao.create(dept);
        dao.retrieve(dept);
    }

}
