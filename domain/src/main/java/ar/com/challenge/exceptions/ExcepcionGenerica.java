package ar.com.challenge.exceptions;

import ar.com.challenge.errores.DetalleErrorChallenge;

import java.util.List;

public interface ExcepcionGenerica {
    String getMensaje();
    List<DetalleErrorChallenge> getDetalles();
}
