package ar.com.challenge.errores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleErrorPrecios {
    private String objetivo;
    private String mensaje;

    public DetalleErrorPrecios(final Class clase, final String mensaje) {
        this.objetivo = clase.getEnclosingMethod().getName();
        this.mensaje = mensaje;
    }
}
