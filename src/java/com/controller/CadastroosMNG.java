/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.CadastroosDAOLocal;
import com.entidades.Cadastroos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.validation.constraints.Pattern;

@Named(value = "cadastroosMNG")
@RequestScoped
public class CadastroosMNG implements Serializable {

    @EJB
    CadastroosDAOLocal dao;
    private int codOS;
    private String descricaoEquipamento;
    private String marca;
    private String modelo;
    private String outros;
    private String problemaInformado;
    private String problemaDetectado;
    private Long valorConserto;
    private Date dataEntrada;
    private Date dataSaida;
    private char consertoRealizado;
    private int codCliente;

    /**
     * Creates a new instance of DepartamentoMNG
     */
    public CadastroosMNG() {
    }

    public CadastroosDAOLocal getDao() {
        return dao;
    }

    public void setDao(CadastroosDAOLocal dao) {
        this.dao = dao;
    }

    public int getCodOS() {
        return codOS;
    }

    public void setCodOS(int codOS) {
        this.codOS = codOS;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public String getProblemaInformado() {
        return problemaInformado;
    }

    public void setProblemaInformado(String problemaInformado) {
        this.problemaInformado = problemaInformado;
    }

    public String getProblemaDetectado() {
        return problemaDetectado;
    }

    public void setProblemaDetectado(String problemaDetectado) {
        this.problemaDetectado = problemaDetectado;
    }

    public Long getValorConserto() {
        return valorConserto;
    }

    public void setValorConserto(Long valorConserto) {
        this.valorConserto = valorConserto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public char getConsertoRealizado() {
        return consertoRealizado;
    }

    public void setConsertoRealizado(char consertoRealizado) {
        this.consertoRealizado = consertoRealizado;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getDescricaoEquipamento() {
        return descricaoEquipamento;
    }

    public void setDescricaoEquipamento(String descricaoEquipamento) {
        this.descricaoEquipamento = descricaoEquipamento;
    }

    public Cadastroos getCadastroos(Integer cod) {
        Cadastroos dept = new Cadastroos();
        dept.setCod(cod);
        return dao.retrieve(dept);

    }

    public List<Cadastroos> getLista() {
        return dao.listaTodos();
    }

    public List<SelectItem> getListaSelectItem() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(null, ""));
        for (Cadastroos dept : dao.listaTodos()) {
            lista.add(new SelectItem(dept, String.valueOf(dept.getCodcliente())));
        }
        return lista;
    }

    public void retrieve() {
        Cadastroos dept = new Cadastroos();

        dept.getCod();
        dept.getDescricaoequipamento();
        dept.getMarca();
        dept.getModelo();
        dept.getOutros();
        dept.getDescricaoproblemainformado();
        dept.getDescricaoproblemadetectado();
        dept.getValorconserto();
        dept.getDtentrada();
        dept.getDtsaida();
        dept.getConsertorealizado();
        dept.getCodcliente();
        dao.retrieve(dept);
        
    }
    
    

    public String save() {
        Cadastroos dept = new Cadastroos();
        dept.setCod(codOS);
        dept.setDescricaoequipamento(descricaoEquipamento);
        dept.setMarca(marca);
        dept.setModelo(modelo);
        dept.setOutros(outros);
        dept.setDescricaoproblemainformado(problemaInformado);
        dept.setDescricaoproblemadetectado(problemaDetectado);
        dept.setValorconserto(valorConserto);
        dept.setDtentrada(dataEntrada);
        dept.setDtsaida(dataSaida);
        dept.setConsertorealizado(consertoRealizado);
        dept.setCodcliente(codCliente);
        dao.create(dept);
        return "index";
    }

//    public void remove() {
//        Integer index = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codExcluir").toString());
//        Cadastroos dept = new Cadastroos();
//        dept.setCod(index);
//        dao.delete(dept);
//        this.clear(null);
//    }
//    public String prepUpdate() {
//        Integer index = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codEditar").toString());
//        System.out.println("alterar" + index);
//        Cadastroos dept = new Cadastroos();
//        dept.setCod(index);
//        dept = dao.retrieve(dept);
//        this.codigo = dept.getCod().toString();
//        this.descricaoEquipamento = dept.getDescricaoequipamento();
//        return "departamentoUpdate";
//    }
//    public String update() {
//        Cadastroos dept = new Cadastroos();
//        dept.setCod(Integer.valueOf(codigo));
//        dept.setDescricaoequipamento(descricaoEquipamento);
//        dao.update(dept);
//        return "departamentoList";
//    }
}
