package ar.com.challenge.controller;

import ar.com.challenge.dto.PrecioDto;
import ar.com.challenge.service.PrecioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PrecioControllerTest {

    private static final LocalDateTime FECHA_APLICACION_1 = LocalDateTime.of(2020, Month.JUNE, 14, 10, 0, 0);
    private static final LocalDateTime FECHA_APLICACION_2 = LocalDateTime.of(2020, Month.JUNE, 14, 16, 0, 0);
    private static final LocalDateTime FECHA_APLICACION_3 = LocalDateTime.of(2020, Month.JUNE, 14, 21, 0, 0);
    private static final LocalDateTime FECHA_APLICACION_4 = LocalDateTime.of(2020, Month.JUNE, 15, 10, 0, 0);
    private static final LocalDateTime FECHA_APLICACION_5 = LocalDateTime.of(2020, Month.JUNE, 16, 21, 0, 0);
    private static final Integer SOME_MARCA = 1;
    private static final Integer SOME_PRODUCTO = 35455;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_obtenerPrecio_when_FechaAplicacion1_expect_results() throws Exception {
        PrecioDto result = PrecioDto
                .builder()
                .idTarifaPrecios(1)
                .fechaInicio(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                .idMarca(1)
                .idProducto(35455)
                .precioFinal(new BigDecimal("35.50"))
                .build();
        var response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/precios")
                                .param("fechaAplicacion", String.valueOf(FECHA_APLICACION_1))
                                .param("idProducto", String.valueOf(SOME_PRODUCTO))
                                .param("idMarca", String.valueOf(SOME_MARCA)))
                .andExpect(status().isOk())
                .andReturn();

        var precioDto = objectMapper.readValue(response.getResponse().getContentAsString(), PrecioDto.class);
        assert precioDto.equals(result);
    }

    @Test
    public void test_obtenerPrecio_when_FechaAplicacion2_expect_results() throws Exception {
        PrecioDto result = PrecioDto
                .builder()
                .idTarifaPrecios(2)
                .fechaInicio(LocalDateTime.of(2020, Month.JUNE, 14, 15, 0, 0))
                .idMarca(1)
                .idProducto(35455)
                .precioFinal(new BigDecimal("25.45"))
                .build();
        var response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/precios")
                                .param("fechaAplicacion", String.valueOf(FECHA_APLICACION_2))
                                .param("idProducto", String.valueOf(SOME_PRODUCTO))
                                .param("idMarca", String.valueOf(SOME_MARCA)))
                .andExpect(status().isOk())
                .andReturn();

        var precioDto = objectMapper.readValue(response.getResponse().getContentAsString(), PrecioDto.class);
        assert precioDto.equals(result);
    }

    @Test
    public void test_obtenerPrecio_when_FechaAplicacion3_expect_results() throws Exception {
        PrecioDto result = PrecioDto
                .builder()
                .idTarifaPrecios(1)
                .fechaInicio(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                .idMarca(1)
                .idProducto(35455)
                .precioFinal(new BigDecimal("35.50"))
                .build();
        var response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/precios")
                                .param("fechaAplicacion", String.valueOf(FECHA_APLICACION_3))
                                .param("idProducto", String.valueOf(SOME_PRODUCTO))
                                .param("idMarca", String.valueOf(SOME_MARCA)))
                .andExpect(status().isOk())
                .andReturn();

        var precioDto = objectMapper.readValue(response.getResponse().getContentAsString(), PrecioDto.class);
        assert precioDto.equals(result);
    }

    @Test
    public void test_obtenerPrecio_when_FechaAplicacion4_expect_results() throws Exception {
        PrecioDto result = PrecioDto
                .builder()
                .idTarifaPrecios(3)
                .fechaInicio(LocalDateTime.of(2020, Month.JUNE, 15, 0, 0, 0))
                .idMarca(1)
                .idProducto(35455)
                .precioFinal(new BigDecimal("30.50"))
                .build();
        var response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/precios")
                                .param("fechaAplicacion", String.valueOf(FECHA_APLICACION_4))
                                .param("idProducto", String.valueOf(SOME_PRODUCTO))
                                .param("idMarca", String.valueOf(SOME_MARCA)))
                .andExpect(status().isOk())
                .andReturn();

        var precioDto = objectMapper.readValue(response.getResponse().getContentAsString(), PrecioDto.class);
        assert precioDto.equals(result);
    }

    @Test
    public void test_obtenerPrecio_when_FechaAplicacion5_expect_results() throws Exception {
        PrecioDto result = PrecioDto
                .builder()
                .idTarifaPrecios(4)
                .fechaInicio(LocalDateTime.of(2020, Month.JUNE, 15, 16, 0, 0))
                .idMarca(1)
                .idProducto(35455)
                .precioFinal(new BigDecimal("38.95"))
                .build();
        var response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/precios")
                                .param("fechaAplicacion", String.valueOf(FECHA_APLICACION_5))
                                .param("idProducto", String.valueOf(SOME_PRODUCTO))
                                .param("idMarca", String.valueOf(SOME_MARCA)))
                .andExpect(status().isOk())
                .andReturn();

        var precioDto = objectMapper.readValue(response.getResponse().getContentAsString(), PrecioDto.class);
        assert precioDto.equals(result);
    }

}
