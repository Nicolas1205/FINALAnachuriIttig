package ar.edu.unju.edm.Final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.List;

import ar.edu.unju.edm.Final.model.Punto;
import lombok.ToString;

@Entity
@Table(name = "turistas")
@Getter
@Setter
@NoArgsConstructor
public class Turista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turista_id")
    private int turistaId;

    private String nombre;

    private String password;

    private String rol;

    private boolean estado;

    @OneToMany(mappedBy = "turista")
    private List<Punto> puntos;


    @OneToMany(mappedBy = "turista")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "turista")
    private Set<Valoracion> valoraciones;

    public Turista(String nombre) {
        this.nombre = nombre;
    }
}
