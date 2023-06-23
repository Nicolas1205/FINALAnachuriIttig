package ar.edu.unju.edm.Final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.MapsId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "valoraciones")
@Getter
@Setter
@ToString
public class Valoracion {
    @EmbeddedId
    public ValoracionKey id;

    @ManyToOne
    @MapsId("turistaId")
    @JoinColumn(name = "turista_id")
    public Turista turista;

    @ManyToOne
    @MapsId("puntoId")
    @JoinColumn(name = "punto_id")
    public Punto punto;

    @Size(min=0, max=5)
    @NotNull
    public int rating;

    public Valoracion(int rating) {
        this.rating = rating;
    }

    public Valoracion() {
        this.punto = new Punto();
        this.turista = new Turista();
        this.id = new ValoracionKey();
    }

}
