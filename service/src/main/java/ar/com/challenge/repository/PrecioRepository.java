package ar.com.challenge.repository;

import ar.com.challenge.model.Precio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PrecioRepository extends PagingAndSortingRepository<Precio, Long> {

    @Query("SELECT p FROM Precio p "
            + "WHERE p.fechaInicio <= :fechaAplicacion "
            + "AND p.fechaFin >= :fechaAplicacion "
            + "AND p.idProducto = :idProducto "
            + "AND p.idMarca = :idMarca "
            + "ORDER BY p.prioridad DESC"
    )
    Precio findFirstBy(LocalDateTime fechaAplicacion,
                                Integer idProducto,
                                Integer idMarca);


}

