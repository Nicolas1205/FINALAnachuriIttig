package ar.edu.unju.edm.Final.service;

import ar.edu.unju.edm.Final.model.Turista;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;
import java.util.List;

@Service
public interface ITuristaService {
		public void addTurista(Turista turista);
		public Optional<Turista> getTurista(int codigo);
		public void deleteTurista(int codigo);
		public List<Turista> getTurista();
}
