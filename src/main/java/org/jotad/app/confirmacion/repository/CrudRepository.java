package org.jotad.app.confirmacion.repository;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T> {
    List<T> list(String texto) throws SQLException;
    T byId(Integer id) throws SQLException;
    void save(T t) throws SQLException;
    void delete(Integer id) throws SQLException;
}
