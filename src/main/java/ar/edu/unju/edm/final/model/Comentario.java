package ar.edu.unju.edm.Final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="comentarios")
@Getter @Setter @ToString @NoArgsConstructor
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

		public String titulo;
		public String descripcion;

		public Comentario (String titulo, String descripcion) {
				this.descripcion = descripcion;
				this.titulo = titulo;
		}
}
