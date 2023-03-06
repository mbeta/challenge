package ar.com.challenge.service;

import ar.com.challenge.dto.PrecioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Slf4j
public class PrecioService {

    @Autowired
    public PrecioService() {
    }

    public PrecioDto obtenerTarifa(LocalDateTime fechaAplicacion, Integer idProducto, Integer idMarca){
        return null;
    }
}
