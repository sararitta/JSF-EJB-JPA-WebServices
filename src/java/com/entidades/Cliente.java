/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francisco Neto
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCod", query = "SELECT c FROM Cliente c WHERE c.cod = :cod")
    , @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cliente.findBySobrenome", query = "SELECT c FROM Cliente c WHERE c.sobrenome = :sobrenome")
    , @NamedQuery(name = "Cliente.findByDtnascimento", query = "SELECT c FROM Cliente c WHERE c.dtnascimento = :dtnascimento")
    , @NamedQuery(name = "Cliente.findByEndereco", query = "SELECT c FROM Cliente c WHERE c.endereco = :endereco")
    , @NamedQuery(name = "Cliente.findByContatocel", query = "SELECT c FROM Cliente c WHERE c.contatocel = :contatocel")
    , @NamedQuery(name = "Cliente.findByContatofixo", query = "SELECT c FROM Cliente c WHERE c.contatofixo = :contatofixo")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod")
    private Integer cod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtnascimento")
    @Temporal(TemporalType.DATE)
    private Date dtnascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "contatocel")
    private String contatocel;
    @Size(max = 12)
    @Column(name = "contatofixo")
    private String contatofixo;
    @JoinColumn(name = "codos", referencedColumnName = "cod")
    @ManyToOne
    private Cadastroos codos;

    public Cliente() {
    }

    public Cliente(Integer cod) {
        this.cod = cod;
    }

    public Cliente(Integer cod, String nome, Date dtnascimento, String endereco, String contatocel) {
        this.cod = cod;
        this.nome = nome;
        this.dtnascimento = dtnascimento;
        this.endereco = endereco;
        this.contatocel = contatocel;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
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

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContatocel() {
        return contatocel;
    }

    public void setContatocel(String contatocel) {
        this.contatocel = contatocel;
    }

    public String getContatofixo() {
        return contatofixo;
    }

    public void setContatofixo(String contatofixo) {
        this.contatofixo = contatofixo;
    }

    public Cadastroos getCodos() {
        return codos;
    }

    public void setCodos(Cadastroos codos) {
        this.codos = codos;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Cliente[ cod=" + cod + " ]";
    }
    
}
