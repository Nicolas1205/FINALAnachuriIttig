package ar.edu.unju.edm.Final.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.Final.model.Comentario;
import ar.edu.unju.edm.Final.model.ComentarioKey;

@Repository
public interface ComentarioRepository extends ListCrudRepository<Comentario, ComentarioKey> {
}
