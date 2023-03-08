package ar.com.challenge.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorPrecios {

    PRODUCTO_NO_ENCONTRADO(ProductoNoEncontrado.class),
    MARCA_NO_ENCONTRADA(MarcaNoEncontrada.class),
    ERROR_GENERICO(ExcepcionPrecios.class),
    PETICION_INCORRECTA(PeticionIncorrecta.class),
    VALIDACION_INCORRECTA(ValidacionIncorrecta.class);

    private final Class<? extends ExcepcionPrecios> excepcion;

    public String getCodigoError() {
        return this.name();
    }

    public static ErrorPrecios obtenerPorClaseExcepcion(final Class<? extends ExcepcionPrecios> claseExcepcion) {
        for (ErrorPrecios errorPrecios : values()) {
            if (errorPrecios.excepcion.equals(claseExcepcion)) {
                return errorPrecios;
            }
        }
        throw new IllegalArgumentException("Clase no válida");
    }

    public static ErrorPrecios obtenerPorCodigoError(final String codigo) {
        for (ErrorPrecios errorPrecios : values()) {
            if (errorPrecios.name().equals(codigo)) {
                return errorPrecios;
            }
        }
        throw new IllegalArgumentException("Código no válido");
    }

    public static void validarClaseCodigo(final Class claseExcepcion, final String codigo) {
        if (!obtenerPorClaseExcepcion(claseExcepcion).name().equals(codigo)) {
            throw new IllegalArgumentException("Código inválido para esta excepción");
        }
    }
}
