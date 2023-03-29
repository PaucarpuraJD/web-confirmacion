package org.jotad.app.confirmacion.repository;

import org.jotad.app.confirmacion.models.Sacramento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SacramentoRepositoryImpl implements CrudRepository<Sacramento> {

    private Connection conn;

    public SacramentoRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Sacramento> list(String texto) throws SQLException {
        List<Sacramento> sacramentos = new ArrayList<>();
        try (PreparedStatement psmt = conn.prepareStatement("SELECT * FROM sacramentos WHERE nombre LIKE ? ORDER BY id ASC")){
            psmt.setString(1,"%" + texto + "%");
            try (ResultSet rs = psmt.executeQuery()){
                while (rs.next()){
                    Sacramento sacramento = getSacramento(rs);
                    sacramentos.add(sacramento);
                }
            }
        }
        return sacramentos;
    }

    @Override
    public Sacramento byId(Integer id) throws SQLException {
        Sacramento sacramento = null;
        try (PreparedStatement psmt = conn.prepareStatement("SELECT * FROM sacramentos WHERE id=?")){
            psmt.setInt(1, id);
            try (ResultSet rs = psmt.executeQuery()){
                if (rs.next()){
                    sacramento = getSacramento(rs);
                }
            }
        }
        return sacramento;
    }

    @Override
    public void save(Sacramento sacramento) throws SQLException {
        String sql;
        if (sacramento.getId() != null && sacramento.getId() > 0){
            sql = "UPDATE sacramentos SET nombre=? WHERE id=?";
        }else {
            sql = "INSERT INTO sacramentos (nombre) VALUES (?)";
        }
        try (PreparedStatement psmt = conn.prepareStatement(sql)){
            psmt.setString(1, sacramento.getNombre());
            if (sacramento.getId() != null && sacramento.getId() > 0){
                psmt.setInt(2, sacramento.getId());
            }
            psmt.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM sacramentos WHERE id=?";
        try (PreparedStatement psmt = conn.prepareStatement(sql)){
            psmt.setInt(1, id);
            psmt.executeUpdate();
        }
    }

    private static Sacramento getSacramento(ResultSet rs) throws SQLException {
        Sacramento sacramento = new Sacramento();
        sacramento.setId(rs.getInt("id"));
        sacramento.setNombre(rs.getString("nombre"));
        return sacramento;
    }
}
