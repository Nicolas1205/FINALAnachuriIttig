package ar.edu.unju.edm.Final.repository;

import ar.edu.unju.edm.Final.model.Turista;
import ar.edu.unju.edm.Final.util.PuntoWithAverage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.Final.model.Punto;

import java.util.List;


@Repository
public interface PuntoRepository extends ListCrudRepository<Punto, Integer> {
    @Query("SELECT NEW ar.edu.unju.edm.Final.util.PuntoWithAverage(p, AVG(v.rating)) " +
            "FROM Punto p LEFT JOIN p.valoraciones v GROUP BY p.puntoId ORDER BY AVG(v.rating) DESC")
    List<PuntoWithAverage> findAllWithAverage();

    @Query("SELECT NEW ar.edu.unju.edm.Final.util.PuntoWithAverage(p, AVG(v1.rating), v2.rating) FROM Punto p " +
            "LEFT JOIN p.valoraciones v1 " +
            "LEFT JOIN p.valoraciones v2 ON v2.turista = ?1 " +
            "GROUP BY p.puntoId ORDER BY AVG(v1.rating) DESC")
    List<PuntoWithAverage> findAllWithAverageAndUserRating(Turista turista);
}
