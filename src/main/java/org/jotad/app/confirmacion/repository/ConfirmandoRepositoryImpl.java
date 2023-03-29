package org.jotad.app.confirmacion.repository;

import org.jotad.app.confirmacion.models.Confirmando;

import java.sql.SQLException;
import java.util.List;

public class ConfirmandoRepositoryImpl implements CrudRepository<Confirmando> {
    @Override
    public List<Confirmando> list(String texto) throws SQLException {
        return null;
    }

    @Override
    public Confirmando byId(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void save(Confirmando confirmando) throws SQLException {

    }

    @Override
    public void delete(Integer id) throws SQLException {

    }
}
