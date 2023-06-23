package ar.edu.unju.edm.Final.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;


@Embeddable
@Data
@NoArgsConstructor
public class ValoracionKey implements Serializable {
    @Column(name = "turista_id")
    public int turistaId;
    @Column(name = "punto_id")
    public int puntoId;

    public ValoracionKey(int turistaId, int puntoId) {
        this.turistaId = turistaId;
        this.puntoId = puntoId;
    }
}
