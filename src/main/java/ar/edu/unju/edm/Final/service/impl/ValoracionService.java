package ar.edu.unju.edm.Final.service.impl;

import ar.edu.unju.edm.Final.model.Valoracion;
import ar.edu.unju.edm.Final.model.ValoracionKey;
import ar.edu.unju.edm.Final.service.IValoracionService;
import ar.edu.unju.edm.Final.repository.ValoracionRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@Service
public class ValoracionService implements IValoracionService {
		@Autowired
		ValoracionRepository valoracionRepository;

		public void addValoracion(Valoracion valoracion) {
				valoracionRepository.save(valoracion);
		}
		public Optional<Valoracion> getValoracion(ValoracionKey codigo){
				return valoracionRepository.findById(codigo);
		}
}
