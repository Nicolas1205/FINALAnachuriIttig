package ar.edu.unju.edm.Final.service;

import ar.edu.unju.edm.Final.model.Turista;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public interface ITuristaService {
    void addTurista(Turista turista);

    Optional<Turista> getTurista(int codigo);

    void deleteTurista(int codigo);

    List<Turista> getTurista();
}
