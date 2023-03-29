package org.jotad.app.confirmacion.repository;

import org.jotad.app.confirmacion.models.Confirmando;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConfirmandoRepositoryImpl implements CrudRepository<Confirmando> {

    private Connection conn;

    public ConfirmandoRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Confirmando> list(String texto) throws SQLException {
        List<Confirmando> confirmandos = new ArrayList<>();
        try (PreparedStatement psmt = conn.prepareStatement("")){

        }
        return confirmandos;
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
