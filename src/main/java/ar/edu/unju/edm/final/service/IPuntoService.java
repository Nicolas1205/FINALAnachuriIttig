package ar.edu.unju.edm.Final.service;

import ar.edu.unju.edm.Final.model.Punto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;
import java.util.List;

@Service
public interface IPuntoService {
		public void addPunto(Punto punto);
		public Optional<Punto> getPunto(int codigo);
		public void deletePunto(int codigo);
		public List<Punto> getPuntos();
}
