package ar.edu.unju.edm.final.service.impl;

import ar.edu.unju.edm.tp3.model.Punto;
import ar.edu.unju.edm.tp3.service.IPuntoService;
import ar.edu.unju.edm.tp3.repository.PuntoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;
import java.util.List;


@Service
public class PuntoService implements IPuntoService {
		@Autowired
		PuntoRepository puntoRepository;

		void addPunto(Punto punto) {
				puntoRepository.save(punto);
		}
		Optional<Punto> getPunto(int codigo){
				return puntoRepository.findById(codigo);
		}
		void deletePunto(int codigo) {
				puntoRepository.deleteById(codigo);
		}
		List<Punto> getPuntos() {
				return puntoRepository.findAll();
		}
}
