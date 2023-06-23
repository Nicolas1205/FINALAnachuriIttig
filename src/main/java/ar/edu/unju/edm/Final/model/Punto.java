package ar.edu.unju.edm.Final.model;

import jakarta.persistence.*;
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
    private int puntoId;
    private String nombre;
    private String descripcion;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "turista_id")//, nullable=false)
    private Turista turista;

    @OneToMany(mappedBy = "punto")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "punto")
    private List<Valoracion> valoraciones;

    public Punto(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUserRating(Integer turistaId) {
        System.out.println(turistaId);
        return
                valoraciones.stream().filter(valoracion -> valoracion.getTurista().getTuristaId() == turistaId)
                        .map(Valoracion::getRating).findFirst().orElse(null);
    }
}
