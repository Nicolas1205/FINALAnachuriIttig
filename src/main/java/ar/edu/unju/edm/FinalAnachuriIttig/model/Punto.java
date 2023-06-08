package ar.edu.unju.edm.final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="puntos")
@Component
@Getter @Setter @NoArgsConstructor
public class Punto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int puntoId;
		String nombre;

		@OneToMany(mappedBy = "punto")
		Set<Comentario> comentarios;
		@OneToMany(mappedBy = "punto")
		Set<Valoracion> valoraciones;

		public Punto(String nombre) {
				this.nombre = nombre;
		}
}
