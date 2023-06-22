package ar.edu.unju.edm.Final.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.Final.model.Turista;

import java.util.List;

@Repository
public interface TuristaRepository extends ListCrudRepository<Turista,Integer> {
}
