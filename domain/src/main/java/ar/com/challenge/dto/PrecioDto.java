package ar.com.challenge.dto;

import ar.com.challenge.enums.EnumMoneda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrecioDto {

    private Integer marca;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private BigDecimal precio;
    private Integer producto;
    private Integer prioridad;
    private EnumMoneda moneda;


}
