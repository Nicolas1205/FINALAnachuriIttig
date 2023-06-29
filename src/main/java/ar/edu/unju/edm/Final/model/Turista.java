package ar.edu.unju.edm.Final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.List;

import ar.edu.unju.edm.Final.model.Punto;

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

    @Override
    public String toString() {
        return "Turista{" +
                "turistaId=" + turistaId +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", estado=" + estado +
                '}';
    }

    @Column(unique = true)
    @NotNull(message = "debe especificar un nombre")
    @NotBlank(message = "no debe estar en blanco")
    private String nombre;

    @NotNull(message = "debe especificar una contraseña")
    @NotBlank(message = "no debe estar en blanco")
    private String password;

    @NotBlank(message = "debe especificar un rol")
    private String rol;

    private boolean estado;

    @OneToMany(mappedBy = "turista", cascade = CascadeType.REMOVE)
    private List<Punto> puntos;


    @OneToMany(mappedBy = "turista", cascade = CascadeType.REMOVE)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "turista", cascade = CascadeType.REMOVE)
    private Set<Valoracion> valoraciones;

    public Turista(@NotNull String nombre) {
        this.nombre = nombre;
    }
}
