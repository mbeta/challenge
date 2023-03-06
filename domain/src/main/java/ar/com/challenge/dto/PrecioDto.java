package ar.com.challenge.dto;

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


    private Integer producto;
    private Integer marca;
    private BigDecimal precio;
    private LocalDateTime fechaInicio;

}
