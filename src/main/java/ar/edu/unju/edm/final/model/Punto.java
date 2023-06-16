package ar.edu.unju.edm.Final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.List;
import ar.edu.unju.edm.Final.model.Turista;



@Entity
@Table(name="puntos")
@Getter @Setter @NoArgsConstructor @ToString
public class Punto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int puntoId;
		public String nombre;

		@ManyToOne
		@JoinColumn(name = "turista_id")//, nullable=false)
		public Turista turista;

		@OneToMany(mappedBy = "punto")
		public Set<Comentario> comentarios;

		/*
		@OneToMany(mappedBy = "punto")
		Set<Valoracion> valoraciones;
		*/

		public Punto(String nombre) {
				this.nombre = nombre;
		}
}
