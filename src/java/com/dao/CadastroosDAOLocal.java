package com.dao;
import com.entidades.Cadastroos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mertins
 */
@Local
public interface CadastroosDAOLocal {

    Cadastroos create(Cadastroos value);

    Cadastroos retrieve(Cadastroos value);

    void update(Cadastroos value);

    void delete(Cadastroos value);

    List<Cadastroos> listaTodos();

    boolean valida(Cadastroos value);
}
