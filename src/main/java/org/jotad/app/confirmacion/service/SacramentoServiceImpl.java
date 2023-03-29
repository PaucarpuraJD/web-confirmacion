package org.jotad.app.confirmacion.service;

import org.jotad.app.confirmacion.models.Sacramento;
import org.jotad.app.confirmacion.repository.CrudRepository;
import org.jotad.app.confirmacion.repository.SacramentoRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SacramentoServiceImpl implements SacramentoService{

    private CrudRepository<Sacramento> repository;

    public SacramentoServiceImpl(Connection conn) {
        this.repository = new SacramentoRepositoryImpl(conn);
    }

    @Override
    public List<Sacramento> list(String texto) {
        try {
            return repository.list(texto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Sacramento> byId(Integer id) {
        try {
            return Optional.ofNullable(repository.byId(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Sacramento sacramento) {
        try {
            repository.save(sacramento);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            repository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
