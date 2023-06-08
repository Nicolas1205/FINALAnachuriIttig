package ar.edu.unju.edm.final.service;

import ar.edu.unju.edm.final.model.Punto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;
import java.util.List;

@Service
public interface IProductosService {
		void addPunto(Punto punto);
		Optional<Punto> getPunto(int codigo);
		void deleteProducto(int codigo);
		List<Punto> getPuntos();
}
