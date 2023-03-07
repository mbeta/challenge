package ar.com.challenge.model;

import ar.com.challenge.enums.EnumMoneda;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Precio {
    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrecio;

    private Integer idMarca;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private BigDecimal precioFinal;
    private Integer idTarifaPrecios;
    private Integer idProducto;
    private Integer prioridad;
    @Enumerated(EnumType.STRING)
    private EnumMoneda moneda;
    @CreationTimestamp
    private LocalDate fechaHoraRegistracion;

    @UpdateTimestamp
    private LocalDateTime fechaHoraModificacion;
}
