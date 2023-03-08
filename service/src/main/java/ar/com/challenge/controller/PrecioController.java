package ar.com.challenge.controller;

import ar.com.challenge.dto.PrecioDto;
import ar.com.challenge.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/precios")
public class PrecioController {

    private PrecioService precioService;

    @Autowired
    public PrecioController(final PrecioService precioService) {
        this.precioService = precioService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PrecioDto obtenerTarifa(
            @RequestParam(name = "fechaAplicacion") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            final LocalDateTime fechaAplicacion,
            @RequestParam(name = "idProducto") final Integer idProducto,
            @RequestParam(name = "idMarca") final Integer idMarca) {

        return precioService.obtenerTarifa(fechaAplicacion, idProducto, idMarca);
    }
}
