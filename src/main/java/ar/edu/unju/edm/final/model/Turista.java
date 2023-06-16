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

@Entity
@Table(name="turistas")
@Getter @Setter @NoArgsConstructor
public class Turista {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "turista_id")
		public int turistaId;

		public String nombre;

		@OneToMany(mappedBy="turista")
		public List<Punto> puntos;
		
		
		@OneToMany(mappedBy = "turista")
		public Set<Comentario> comentarios;

		@OneToMany(mappedBy = "turista")
		public Set<Valoracion> valoraciones;

		public Turista(String nombre) {
				this.nombre = nombre;
		}
}
