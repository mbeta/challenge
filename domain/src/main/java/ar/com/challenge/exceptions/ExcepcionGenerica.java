package ar.com.challenge.exceptions;

import ar.com.challenge.errores.DetalleErrorPrecios;

import java.util.List;

public interface ExcepcionGenerica {
    String getMensaje();
    List<DetalleErrorPrecios> getDetalles();
}
