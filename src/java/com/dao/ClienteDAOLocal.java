package com.dao;
import com.entidades.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mertins
 */
@Local
public interface ClienteDAOLocal {

    Cliente create(Cliente value);

    Cliente retrieve(Cliente value);

    void update(Cliente value);

    void delete(Cliente value);

    List<Cliente> listaTodos();

    boolean valida(Cliente value);
}
