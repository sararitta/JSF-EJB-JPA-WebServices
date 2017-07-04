/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francisco Neto
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByCod", query = "SELECT p FROM Produto p WHERE p.cod = :cod")
    , @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome")
    , @NamedQuery(name = "Produto.findByMarca", query = "SELECT p FROM Produto p WHERE p.marca = :marca")
    , @NamedQuery(name = "Produto.findByModelo", query = "SELECT p FROM Produto p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Produto.findByValorcompra", query = "SELECT p FROM Produto p WHERE p.valorcompra = :valorcompra")
    , @NamedQuery(name = "Produto.findByValorrevenda", query = "SELECT p FROM Produto p WHERE p.valorrevenda = :valorrevenda")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod")
    private Integer cod;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 200)
    @Column(name = "marca")
    private String marca;
    @Size(max = 200)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorcompra")
    private long valorcompra;
    @Column(name = "valorrevenda")
    private Long valorrevenda;

    public Produto() {
    }

    public Produto(Integer cod) {
        this.cod = cod;
    }

    public Produto(Integer cod, long valorcompra) {
        this.cod = cod;
        this.valorcompra = valorcompra;
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

    public long getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(long valorcompra) {
        this.valorcompra = valorcompra;
    }

    public Long getValorrevenda() {
        return valorrevenda;
    }

    public void setValorrevenda(Long valorrevenda) {
        this.valorrevenda = valorrevenda;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Produto[ cod=" + cod + " ]";
    }
    
}
