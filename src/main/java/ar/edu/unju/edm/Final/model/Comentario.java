package ar.edu.unju.edm.Final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "comentarios")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int comentarioId;

    @ManyToOne
    @JoinColumn(name = "turista_id")
    public Turista turista;

    @ManyToOne
    @JoinColumn(name = "punto_id")
    public Punto punto;

    @NotBlank(message = "no debe estar en blanco")
    public String titulo;
    @Lob
    @Column(columnDefinition = "TEXT")
    public String descripcion;

    public Comentario(String titulo, String descripcion) {
        this.descripcion = descripcion;
        this.titulo = titulo;
    }
}
