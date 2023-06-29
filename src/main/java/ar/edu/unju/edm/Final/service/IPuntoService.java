package ar.edu.unju.edm.Final.service;

import ar.edu.unju.edm.Final.model.Punto;
import ar.edu.unju.edm.Final.model.Turista;
import ar.edu.unju.edm.Final.util.PuntoWithAverage;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public interface IPuntoService {
    void addPunto(Punto punto);

    Optional<Punto> getPunto(int codigo);

    void deletePunto(int codigo);

    List<Punto> getPuntos();

    List<PuntoWithAverage> getPuntosWithAverage(Turista turista);
    List<PuntoWithAverage> getPuntosWithAverage();
}
