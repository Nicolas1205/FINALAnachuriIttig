package ar.edu.unju.edm.Final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

import ar.edu.unju.edm.Final.model.Turista;
import ar.edu.unju.edm.Final.model.Valoracion;

@Entity
@Table(name = "puntos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Punto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int puntoId;
    public String nombre;

    @ManyToOne
    @JoinColumn(name = "turista_id")//, nullable=false)
    public Turista turista;

    @OneToMany(mappedBy = "punto")
    public List<Comentario> comentarios;

    @OneToMany(mappedBy = "punto")
    public List<Valoracion> valoraciones;

    public Punto(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUserRating(Integer turistaId) {
        return
                valoraciones.stream().filter(valoracion -> valoracion.getTurista().getTuristaId() == turistaId)
                        .map(Valoracion::getRating).findFirst().orElse(null);
    }
}
