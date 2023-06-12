package ar.edu.unju.edm.final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Component;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarte.persistence.Embeddable;

@Embeddable
class ComentarioKey implements Serializable {
		@Column(name = "turista_id")
		int turistaId;
		@Column(name = "punto_id")
		int puntoId;

		// HashCode and Equals
}
