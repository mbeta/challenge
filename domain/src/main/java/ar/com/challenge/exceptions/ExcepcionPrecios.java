package ar.com.challenge.exceptions;


import ar.com.challenge.errores.DetalleErrorChallenge;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExcepcionPrecios extends Exception implements ExcepcionGenerica {
    private List<DetalleErrorChallenge> detalles;

    public ExcepcionPrecios(final String mensaje) {
        super(mensaje);
        this.detalles = new ArrayList<>();
    }

    public ExcepcionPrecios(final String mensaje, final DetalleErrorChallenge detalle) {
        super(mensaje);
        this.detalles = Collections.singletonList(detalle);
    }

    public ExcepcionPrecios(final String mensaje, final List<DetalleErrorChallenge> detalles) {
        super(mensaje);
        this.detalles = detalles;
    }

    @Override
    public String getMensaje() {
        return getMessage();
    }
}
