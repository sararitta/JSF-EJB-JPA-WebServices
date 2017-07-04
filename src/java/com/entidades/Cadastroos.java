/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Francisco Neto
 */
@Entity
@Table(name = "cadastroos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadastroos.findAll", query = "SELECT c FROM Cadastroos c")
    , @NamedQuery(name = "Cadastroos.findByCod", query = "SELECT c FROM Cadastroos c WHERE c.cod = :cod")
    , @NamedQuery(name = "Cadastroos.findByDescricaoequipamento", query = "SELECT c FROM Cadastroos c WHERE c.descricaoequipamento = :descricaoequipamento")
    , @NamedQuery(name = "Cadastroos.findByMarca", query = "SELECT c FROM Cadastroos c WHERE c.marca = :marca")
    , @NamedQuery(name = "Cadastroos.findByModelo", query = "SELECT c FROM Cadastroos c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Cadastroos.findByOutros", query = "SELECT c FROM Cadastroos c WHERE c.outros = :outros")
    , @NamedQuery(name = "Cadastroos.findByDescricaoproblemainformado", query = "SELECT c FROM Cadastroos c WHERE c.descricaoproblemainformado = :descricaoproblemainformado")
    , @NamedQuery(name = "Cadastroos.findByDescricaoproblemadetectado", query = "SELECT c FROM Cadastroos c WHERE c.descricaoproblemadetectado = :descricaoproblemadetectado")
    , @NamedQuery(name = "Cadastroos.findByValorconserto", query = "SELECT c FROM Cadastroos c WHERE c.valorconserto = :valorconserto")
    , @NamedQuery(name = "Cadastroos.findByDtentrada", query = "SELECT c FROM Cadastroos c WHERE c.dtentrada = :dtentrada")
    , @NamedQuery(name = "Cadastroos.findByDtsaida", query = "SELECT c FROM Cadastroos c WHERE c.dtsaida = :dtsaida")
    , @NamedQuery(name = "Cadastroos.findByConsertorealizado", query = "SELECT c FROM Cadastroos c WHERE c.consertorealizado = :consertorealizado")
    , @NamedQuery(name = "Cadastroos.findByCodcliente", query = "SELECT c FROM Cadastroos c WHERE c.codcliente = :codcliente")})
public class Cadastroos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod")
    private Integer cod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricaoequipamento")
    private String descricaoequipamento;
    @Size(max = 200)
    @Column(name = "marca")
    private String marca;
    @Size(max = 200)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 200)
    @Column(name = "outros")
    private String outros;
    @Size(max = 200)
    @Column(name = "descricaoproblemainformado")
    private String descricaoproblemainformado;
    @Size(max = 200)
    @Column(name = "descricaoproblemadetectado")
    private String descricaoproblemadetectado;
    @Column(name = "valorconserto")
    private Long valorconserto;
    @Column(name = "dtentrada")
    @Temporal(TemporalType.DATE)
    private Date dtentrada;
    @Column(name = "dtsaida")
    @Temporal(TemporalType.DATE)
    private Date dtsaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consertorealizado")
    private Character consertorealizado;
    @Column(name = "codcliente")
    private Integer codcliente;
    @OneToMany(mappedBy = "codos")
    private Collection<Cliente> clienteCollection;

    public Cadastroos() {
    }

    public Cadastroos(Integer cod) {
        this.cod = cod;
    }

    public Cadastroos(Integer cod, String descricaoequipamento, Character consertorealizado) {
        this.cod = cod;
        this.descricaoequipamento = descricaoequipamento;
        this.consertorealizado = consertorealizado;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDescricaoequipamento() {
        return descricaoequipamento;
    }

    public void setDescricaoequipamento(String descricaoequipamento) {
        this.descricaoequipamento = descricaoequipamento;
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

    public String getDescricaoproblemainformado() {
        return descricaoproblemainformado;
    }

    public void setDescricaoproblemainformado(String descricaoproblemainformado) {
        this.descricaoproblemainformado = descricaoproblemainformado;
    }

    public String getDescricaoproblemadetectado() {
        return descricaoproblemadetectado;
    }

    public void setDescricaoproblemadetectado(String descricaoproblemadetectado) {
        this.descricaoproblemadetectado = descricaoproblemadetectado;
    }

    public Long getValorconserto() {
        return valorconserto;
    }

    public void setValorconserto(Long valorconserto) {
        this.valorconserto = valorconserto;
    }

    public Date getDtentrada() {
        return dtentrada;
    }

    public void setDtentrada(Date dtentrada) {
        this.dtentrada = dtentrada;
    }

    public Date getDtsaida() {
        return dtsaida;
    }

    public void setDtsaida(Date dtsaida) {
        this.dtsaida = dtsaida;
    }

    public Character getConsertorealizado() {
        return consertorealizado;
    }

    public void setConsertorealizado(Character consertorealizado) {
        this.consertorealizado = consertorealizado;
    }

    public Integer getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Integer codcliente) {
        this.codcliente = codcliente;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod != null ? cod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadastroos)) {
            return false;
        }
        Cadastroos other = (Cadastroos) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Cadastroos[ cod=" + cod + " ]";
    }
    
}
