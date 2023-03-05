package ar.com.challenge.errores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorPrecios {
    private String mensaje;
    private String codigoError;
    private List<DetalleErrorPrecios> detalles;
}
