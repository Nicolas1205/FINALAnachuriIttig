package ar.edu.unju.edm.final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.peristence.Component;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="turistas")
@Component
@Getter @Setter @NoArgsConstructor
public class Turista {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int turistaId;
		String nombre;
		@OneToMany(mappedBy = "turista")
		Set<Comentario> comentarios;
		@OneToMany(mappedBy = "turista")
		Set<Valoracion> valoraciones;

		public Turista(String nombre) {
				this.nombre = nombre;
		}
}
