package ar.edu.unju.edm.Final.util;

import ar.edu.unju.edm.Final.model.Punto;

public record PuntoWithAverage(Punto punto, Double average, Integer turistaRating) {
    public PuntoWithAverage(Punto punto, Double average) {
        this(punto, average, null);
    }
}
