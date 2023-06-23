package ar.edu.unju.edm.Final.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.Final.model.Turista;

import java.util.Optional;

@Repository
public interface TuristaRepository extends ListCrudRepository<Turista, Integer> {

    @Query("SELECT u FROM Turista u WHERE u.nombre = :nombre")
    Optional<Turista> findTuristaByNombre(@Param("nombre") String nombre);
}
