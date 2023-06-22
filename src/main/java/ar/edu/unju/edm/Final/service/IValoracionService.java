package ar.edu.unju.edm.Final.service;

import ar.edu.unju.edm.Final.model.Valoracion;
import ar.edu.unju.edm.Final.model.ValoracionKey;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IValoracionService {
		public void addValoracion(Valoracion valoracion);
		public Optional<Valoracion> getValoracion(ValoracionKey codigo);
}
