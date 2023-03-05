package ar.com.challenge.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class MarcaNoEncontrada extends ExcepcionPrecios {

    private Integer marca;

    public MarcaNoEncontrada(final Integer marca){
        super(String.format("No se encontró Marca con identificador: %s", marca));
        this.marca = marca;
    }
}
