package org.jotad.app.confirmacion.service;

import org.jotad.app.confirmacion.models.Sacramento;

import java.util.List;
import java.util.Optional;

public interface SacramentoService {
    List<Sacramento> list(String texto);
    Optional<Sacramento> byId(Integer id);
    void save(Sacramento sacramento);
    void delete(Integer id);
}
