package ar.com.challenge.exceptions;

import ar.com.challenge.errores.DetalleErrorChallenge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ValidacionIncorrecta extends ExcepcionPrecios {
    public ValidacionIncorrecta(final String mensaje) {
        super(mensaje);
    }

    public ValidacionIncorrecta(final String mensaje, final DetalleErrorChallenge detalle) {
        super(mensaje, detalle);
    }

    public ValidacionIncorrecta(final String mensaje, final List<DetalleErrorChallenge> detalles) {
        super(mensaje, detalles);
    }
}
