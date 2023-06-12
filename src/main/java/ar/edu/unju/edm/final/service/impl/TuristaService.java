package ar.edu.unju.edm.Final.service.impl;

import ar.edu.unju.edm.Final.model.Turista;
import ar.edu.unju.edm.Final.service.ITuristaService;
import ar.edu.unju.edm.Final.repository.TuristaRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;
import java.util.List;


@Service
public class TuristaService implements ITuristaService {
		@Autowired
		TuristaRepository turistaRepository;

		public void addTurista(Turista turista) {
				turistaRepository.save(turista);
		}
		public Optional<Turista> getTurista(int codigo){
				return turistaRepository.findById(codigo);
		}
		public void deleteTurista(int codigo) {
				turistaRepository.deleteById(codigo);
		}
		public List<Turista> getTurista() {
				return turistaRepository.findAll();
		}
}
