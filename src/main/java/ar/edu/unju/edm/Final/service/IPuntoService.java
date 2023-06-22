package ar.edu.unju.edm.Final.service;

import ar.edu.unju.edm.Final.model.Punto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public interface IPuntoService {
    void addPunto(Punto punto);

    Optional<Punto> getPunto(int codigo);

    void deletePunto(int codigo);

    List<Punto> getPuntos();
}
