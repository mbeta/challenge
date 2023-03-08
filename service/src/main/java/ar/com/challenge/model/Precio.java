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

    //Identificador de Marca (Cadena del grupo)
    private Integer idMarca;
    //Fecha inicio de aplicacion de Tarifa
    private LocalDateTime fechaInicio;
    //Fecha fin de aplicacion de tarifa
    private LocalDateTime fechaFin;
    //Precio final de venta
    private BigDecimal precioFinal;
    //Identificador de lista de tarifa de precios aplicable
    private Integer idTarifaPrecios;
    //Idetificador de Codigo de Producto
    private Integer idProducto;
    //Desambiguador de aplicacion de precios (Mayor numero, mayor prioridad)
    private Integer prioridad;
    //Iso moneda
    @Enumerated(EnumType.STRING)
    private EnumMoneda moneda;
    @CreationTimestamp
    private LocalDate fechaHoraRegistracion;

    @UpdateTimestamp
    private LocalDateTime fechaHoraModificacion;
}
