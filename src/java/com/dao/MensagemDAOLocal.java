package com.dao;

import com.entidades.Mensagem;
import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author mertins
 */
@Local
public interface MensagemDAOLocal {

    Mensagem create(Mensagem value);

    Mensagem retrieve(Mensagem value);

    void update(Mensagem value);

    void delete(Mensagem value);

    List<Mensagem> listaTodos();

    boolean valida(Mensagem value);
}