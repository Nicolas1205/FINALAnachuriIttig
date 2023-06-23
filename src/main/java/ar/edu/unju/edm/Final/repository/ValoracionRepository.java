package ar.edu.unju.edm.Final.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.Final.model.Valoracion;
import ar.edu.unju.edm.Final.model.ValoracionKey;

@Repository
public interface ValoracionRepository extends ListCrudRepository<Valoracion, ValoracionKey> {
}
