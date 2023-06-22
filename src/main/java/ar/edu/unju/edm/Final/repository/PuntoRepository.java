package ar.edu.unju.edm.Final.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.Final.model.Punto;

@Repository
public interface PuntoRepository extends ListCrudRepository<Punto, Integer> {
}
