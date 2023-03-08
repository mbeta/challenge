package ar.com.challenge.controller;


import ar.com.challenge.errores.ErrorChallenge;
import ar.com.challenge.exceptions.ErrorPrecios;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/error")
    public void handleError(final HttpServletRequest request, final HttpServletResponse httpServletResponse)
            throws IOException {
        HttpStatus status = HttpStatus.valueOf((Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        String mensaje;
        String codigoError;

        switch (status) {
            case NOT_FOUND:
                mensaje = "El recurso no existe";
                codigoError = "RECURSO_NO_ENCONTRADO";
                break;
            default:
                mensaje = "Error desconocido";
                codigoError = ErrorPrecios.ERROR_GENERICO.getCodigoError();
        }

        ErrorChallenge error = new ErrorChallenge(mensaje, codigoError, new ArrayList<>());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.getOutputStream().write(objectMapper.writeValueAsString(error).getBytes());
        httpServletResponse.flushBuffer();
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
