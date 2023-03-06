package ar.com.challenge.service;

import ar.com.challenge.dto.PrecioDto;
import ar.com.challenge.mapper.PrecioMapper;
import ar.com.challenge.model.Precio;
import ar.com.challenge.repository.PrecioRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PrecioServiceTest {


    private static final LocalDateTime FECHA_APLICACION_1 = LocalDateTime.of(2020, Month.JULY, 14, 10, 0, 0);
    private static final LocalDateTime FECHA_APLICACION_2 = LocalDateTime.of(2020, Month.JULY, 14, 16, 0, 0);
    private static final LocalDateTime FECHA_APLICACION_3 = LocalDateTime.of(2020, Month.JULY, 14, 21, 0, 0);
    private static final LocalDateTime FECHA_APLICACION_4 = LocalDateTime.of(2020, Month.JULY, 15, 10, 0, 0);
    private static final LocalDateTime FECHA_APLICACION_5 = LocalDateTime.of(2020, Month.JULY, 16, 21, 0, 0);
    private static final Integer SOME_MARCA = 1;
    private static final Integer SOME_PRODUCTO = 35455;
    private static final Precio SOME_PRECIO = new Precio();

    private static final PrecioDto SOME_PRECIO_DTO = new PrecioDto();

    @Mock
    private PrecioRepository precioRepository;
    @Mock
    private PrecioMapper precioMapper;
    @InjectMocks
    private PrecioService precioService;

    @BeforeAll
    public static void init() {

    }

    @Test
    void test_obtenerPrecio_when_FechaAplicacion1_expect_results() {
        when(precioRepository.obtenerPrecio(FECHA_APLICACION_1, SOME_PRODUCTO, SOME_MARCA)).thenReturn(SOME_PRECIO);
        when(precioMapper.toDto(SOME_PRECIO)).thenReturn(SOME_PRECIO_DTO);

        PrecioDto resultado = precioService.obtenerTarifa(FECHA_APLICACION_1, SOME_PRODUCTO, SOME_MARCA);
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(SOME_PRECIO_DTO, resultado);

        verify(precioRepository, times(1))
                .obtenerPrecio(FECHA_APLICACION_1, SOME_PRODUCTO, SOME_MARCA);
        verify(precioMapper, times(1)).toDto(SOME_PRECIO);

    }

    @Test
    void test_obtenerPrecio_when_FechaAplicacion2_expect_results() {
        when(precioRepository.obtenerPrecio(FECHA_APLICACION_2, SOME_PRODUCTO, SOME_MARCA)).thenReturn(SOME_PRECIO);
        when(precioMapper.toDto(SOME_PRECIO)).thenReturn(SOME_PRECIO_DTO);

        PrecioDto resultado = precioService.obtenerTarifa(FECHA_APLICACION_2, SOME_PRODUCTO, SOME_MARCA);
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(SOME_PRECIO_DTO, resultado);

        verify(precioRepository, times(1))
                .obtenerPrecio(FECHA_APLICACION_2, SOME_PRODUCTO, SOME_MARCA);
        verify(precioMapper, times(1)).toDto(SOME_PRECIO);

    }

    @Test
    void test_obtenerPrecio_when_FechaAplicacion3_expect_results() {
        when(precioRepository.obtenerPrecio(FECHA_APLICACION_3, SOME_PRODUCTO, SOME_MARCA)).thenReturn(SOME_PRECIO);
        when(precioMapper.toDto(SOME_PRECIO)).thenReturn(SOME_PRECIO_DTO);

        PrecioDto resultado = precioService.obtenerTarifa(FECHA_APLICACION_3, SOME_PRODUCTO, SOME_MARCA);
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(SOME_PRECIO_DTO, resultado);

        verify(precioRepository, times(1))
                .obtenerPrecio(FECHA_APLICACION_3, SOME_PRODUCTO, SOME_MARCA);
        verify(precioMapper, times(1)).toDto(SOME_PRECIO);

    }

    @Test
    void test_obtenerPrecio_when_FechaAplicacion4_expect_results() {
        when(precioRepository.obtenerPrecio(FECHA_APLICACION_4, SOME_PRODUCTO, SOME_MARCA)).thenReturn(SOME_PRECIO);
        when(precioMapper.toDto(SOME_PRECIO)).thenReturn(SOME_PRECIO_DTO);

        PrecioDto resultado = precioService.obtenerTarifa(FECHA_APLICACION_4, SOME_PRODUCTO, SOME_MARCA);
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(SOME_PRECIO_DTO, resultado);

        verify(precioRepository, times(1))
                .obtenerPrecio(FECHA_APLICACION_4, SOME_PRODUCTO, SOME_MARCA);
        verify(precioMapper, times(1)).toDto(SOME_PRECIO);

    }

    @Test
    void test_obtenerPrecio_when_FechaAplicacion5_expect_results() {
        when(precioRepository.obtenerPrecio(FECHA_APLICACION_5, SOME_PRODUCTO, SOME_MARCA)).thenReturn(SOME_PRECIO);
        when(precioMapper.toDto(SOME_PRECIO)).thenReturn(SOME_PRECIO_DTO);

        PrecioDto resultado = precioService.obtenerTarifa(FECHA_APLICACION_5, SOME_PRODUCTO, SOME_MARCA);
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(SOME_PRECIO_DTO, resultado);

        verify(precioRepository, times(1))
                .obtenerPrecio(FECHA_APLICACION_5, SOME_PRODUCTO, SOME_MARCA);
        verify(precioMapper, times(1)).toDto(SOME_PRECIO);

    }
}
