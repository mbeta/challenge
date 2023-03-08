package ar.com.challenge.service;

import ar.com.challenge.dto.PrecioDto;
import ar.com.challenge.mapper.PrecioMapper;
import ar.com.challenge.repository.PrecioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PrecioService {
    private final PrecioMapper precioMapper;
    private final PrecioRepository precioRepository;

    @Autowired
    public PrecioService(final PrecioMapper precioMapper, final PrecioRepository precioRepository) {
        this.precioMapper = precioMapper;
        this.precioRepository = precioRepository;
    }

    //Obtener precio de producto a aplicar de mayor prioridad
    public PrecioDto obtenerTarifa(final LocalDateTime fechaAplicacion,
                                   final Integer idProducto,
                                   final Integer idMarca) {
        return precioMapper.toDto(
                precioRepository.findPreciosBy(fechaAplicacion, idProducto, idMarca)
                        .stream()
                        .findFirst()
                        .orElse(null));
    }
}
