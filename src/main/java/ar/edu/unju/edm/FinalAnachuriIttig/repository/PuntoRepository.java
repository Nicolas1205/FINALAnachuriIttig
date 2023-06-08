package ar.edu.unju.edm.final.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.final.model.Punto;

import java.util.List;

@Repository
public interface ProductosRepository extends ListCrudRepository<Punto,Integer> {
}
