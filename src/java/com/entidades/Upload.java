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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "upload")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Upload.findAll", query = "SELECT u FROM Upload u")
    , @NamedQuery(name = "Upload.findByCod", query = "SELECT u FROM Upload u WHERE u.cod = :cod")
    , @NamedQuery(name = "Upload.findByNome", query = "SELECT u FROM Upload u WHERE u.nome = :nome")
    , @NamedQuery(name = "Upload.findByContenttype", query = "SELECT u FROM Upload u WHERE u.contenttype = :contenttype")})
public class Upload implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod")
    private Integer cod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome")
    private String nome;
    @Size(max = 200)
    @Column(name = "contenttype")
    private String contenttype;
    @Lob
    @Column(name = "conteudo")
    private byte[] conteudo;

    public Upload() {
    }

    public Upload(Integer cod) {
        this.cod = cod;
    }

    public Upload(Integer cod, String nome) {
        this.cod = cod;
        this.nome = nome;
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

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
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
        if (!(object instanceof Upload)) {
            return false;
        }
        Upload other = (Upload) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Upload[ cod=" + cod + " ]";
    }
    
}
