/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entidades.Mensagem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sara
 */
@Stateless
public class MensagemDAO implements MensagemDAOLocal {

    @PersistenceContext
    private EntityManager em;

    /**
     * Se o departamento for válido, este método irá fazer o INSERT no SGBD.
     * O Código será inserido pela Sequência e será colocado novamente no objeto Departamento.
     * @param value Departamento a ser inserido
     */
    @Override
    public Mensagem create(Mensagem value) {
        if (this.valida(value)) {
            em.persist(value);
            return value;
        } else {
            return null;
        }
    }

    /**
     * Retorna o departamento do SGBD de acordo com o código do departamento recebido.
     * @param value Departamento a ser carregado do SGBD
     * @return Departamento do SGBD
     */
    @Override
    public Mensagem retrieve(Mensagem value) {
        Mensagem valueRet = em.find(Mensagem.class, value.getCod());
        return valueRet;
    }

    /**
     * Atualiza o departamento no SGBD.
     * @param value Departamento a ser atualizado do SGBD
     */
    @Override
    public void update(Mensagem value) {
        if (this.valida(value)) {
            em.merge(value);
        }
    }

    /**
     * Remove o código do departamento do SGBD.
     * @param value Departamento a ser excluído. Necessita apenas do atributo COD
     */
    @Override
    public void delete(Mensagem value) {
        value = this.retrieve(value);
        em.remove(value);
    }

    /**
     * Retorna uma Lista com todos os Departamentos cadastrados no SGBD.
     * @return Lista com os departamentos.
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco será devolvido nesta Exceção
     */
    @Override
    public List<Mensagem> listaTodos() {
        return (List<Mensagem>) em.createNamedQuery("Mensagem.findAll").getResultList();
    }

    /**
     * Aplica os testes para as regras de negócio.
     * @param value Departamento a ser testado
     * @return true se o Departamento atende as regras de negócio, ou false em caso contrário.
     */
    @Override
    public boolean valida(Mensagem value) {
        boolean ret = false;
        if (value != null) {
            ret = true;
        }
        return ret;
    }
}
