package ar.com.challenge.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ProductoNoEncontrado extends ExcepcionPrecios {

    private Integer producto;

    public ProductoNoEncontrado(final Integer producto){
        super(String.format("No se encontró prducto con identificador: %s", producto));
        this.producto = producto;
    }
}
