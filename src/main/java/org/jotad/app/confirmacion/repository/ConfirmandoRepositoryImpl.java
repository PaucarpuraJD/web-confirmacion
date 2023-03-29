package org.jotad.app.confirmacion.repository;

import org.jotad.app.confirmacion.models.Confirmando;
import org.jotad.app.confirmacion.models.Sacramento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "SELECT c.*, s.nombre AS sacramento FROM confirmandos AS c INNER JOIN sacramentos " +
                " AS s ON (c.sacramento_id=s.id) WHERE nombre LIKE ? ORDER BY id ASC";
        try (PreparedStatement psmt = conn.prepareStatement(sql)){
            psmt.setString(1,texto);
            try(ResultSet rs = psmt.executeQuery()){
                while(rs.next()){
                    Confirmando confirmando = getConfirmando(rs);
                    confirmandos.add(confirmando);

                }
            }
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

    private static Confirmando getConfirmando(ResultSet rs) throws SQLException {
        Confirmando confirmando = new Confirmando();
        confirmando.setId(rs.getInt("id"));
        confirmando.setNombre(rs.getString("nombre"));
        confirmando.setDireccion(rs.getString("direccion"));
        confirmando.setTelefono(rs.getString("telefono"));
        confirmando.setFechaNacimiento(rs.getDate("fehca_nacimiento").toLocalDate());
        Sacramento sacramento = new Sacramento();
        sacramento.setId(rs.getInt("sacramento_id"));
        sacramento.setNombre(rs.getString("sacramento"));
        confirmando.setSacramento(sacramento);
        return confirmando;
    }
}
