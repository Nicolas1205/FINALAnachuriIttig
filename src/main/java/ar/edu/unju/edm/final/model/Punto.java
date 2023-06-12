package ar.edu.unju.edm.Final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.Set;
import ar.edu.unju.edm.Final.model.Turista;



@Entity
@Table(name="puntos")
@Getter @Setter @NoArgsConstructor
public class Punto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int puntoId;
		String nombre;

		@ManyToOne
		@JoinColumn(name = "turista_id")//, nullable=false)
		Turista turista;

		/*
		@OneToMany(mappedBy = "punto")
		Set<Comentario> comentarios;
		@OneToMany(mappedBy = "punto")
		Set<Valoracion> valoraciones;
		*/

		public Punto(String nombre) {
				this.nombre = nombre;
		}
}
