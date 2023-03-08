package ar.com.challenge.exceptions;

import ar.com.challenge.errores.DetalleErrorChallenge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PeticionIncorrecta extends ExcepcionPrecios {
    public PeticionIncorrecta(final String mensaje) {
        super(mensaje);
    }

    public PeticionIncorrecta(final String mensaje, final DetalleErrorChallenge detalle) {
        super(mensaje, detalle);
    }

    public PeticionIncorrecta(final String mensaje, final List<DetalleErrorChallenge> detalles) {
        super(mensaje, detalles);
    }
}
