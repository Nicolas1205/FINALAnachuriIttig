package ar.edu.unju.edm.final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Component;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="comentarios")
@Component
@Getter @Setter @NoArgsConstructor
public class Comentario {
		@EmbeddedId
		ComentarioKey id;

		@ManyToOne
		@MapsId("turistaId")
		@JoinColumns(name = "turista_id")
		Turista turista;

		@ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Punto punto;

		String descripcion;

		public Comentario (String descripcion) {
				this.descripcion = descripcion;
		}
}
