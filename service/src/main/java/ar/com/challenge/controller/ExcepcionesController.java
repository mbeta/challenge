package ar.com.challenge.controller;

import ar.com.challenge.errores.DetalleErrorChallenge;
import ar.com.challenge.errores.ErrorChallenge;
import ar.com.challenge.exceptions.ErrorPrecios;
import ar.com.challenge.exceptions.ExcepcionPrecios;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Log4j2
public class ExcepcionesController {

    @ExceptionHandler({ExcepcionPrecios.class})
    private ResponseEntity<ErrorChallenge> handleExcepcionMep(final ExcepcionPrecios e) {
        log.error(e.getMessage());
        HttpStatus httpStatus = e.getClass().getAnnotation(ResponseStatus.class).value();
        ErrorChallenge errorChallenge = ErrorChallenge.builder()
                .codigoError(ErrorPrecios.obtenerPorClaseExcepcion(e.getClass()).getCodigoError())
                .mensaje(e.getMessage())
                .detalles(e.getDetalles())
                .build();
        return ResponseEntity.status(httpStatus).body(errorChallenge);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    private ResponseEntity<ErrorChallenge> handleConstraintViolationException(final ConstraintViolationException e) {
        log.error(e.getMessage());
        List<DetalleErrorChallenge> detalles = e.getConstraintViolations().stream()
                .map(constraintViolation -> DetalleErrorChallenge.builder()
                        .objetivo(constraintViolation.getInvalidValue() != null
                                ? constraintViolation.getInvalidValue().toString() : "")
                        .mensaje(constraintViolation.getMessageTemplate())
                        .build()
                )
                .collect(Collectors.toList());
        ErrorChallenge errorChallenge = ErrorChallenge.builder()
                .codigoError(ErrorPrecios.VALIDACION_INCORRECTA.getCodigoError())
                .mensaje("Error de validación")
                .detalles(detalles)
                .build();
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorChallenge);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    private ResponseEntity<ErrorChallenge> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        List<DetalleErrorChallenge> detalles = e.getBindingResult().getFieldErrors().stream()
                .map(methodArgumentNotValid -> DetalleErrorChallenge.builder()
                        .objetivo(methodArgumentNotValid.getField() != null ? methodArgumentNotValid.getField() : "")
                        .mensaje(methodArgumentNotValid.getDefaultMessage())
                        .build()
                )
                .collect(Collectors.toList());
        ErrorChallenge errorChallenge = ErrorChallenge.builder()
                .codigoError(ErrorPrecios.VALIDACION_INCORRECTA.getCodigoError())
                .mensaje("Error de validación")
                .detalles(detalles)
                .build();
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorChallenge);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    private ResponseEntity<ErrorChallenge> handleMethodArgumentNotValidException(final MethodArgumentTypeMismatchException e) {
        log.error(e.getMessage());
        List<DetalleErrorChallenge> detalles = new ArrayList<>();
        detalles.add(DetalleErrorChallenge
                .builder()
                .objetivo(e.getName())
                .mensaje(String.format("Error en parametro %s, del valor: %s",e.getName(), e.getValue()))
                .build());

        ErrorChallenge errorChallenge = ErrorChallenge.builder()
                .codigoError(ErrorPrecios.PETICION_INCORRECTA.getCodigoError())
                .mensaje("Error de petición")
                .detalles(detalles)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorChallenge);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class})
    private ResponseEntity<ErrorChallenge> handleMethodArgumentNotValidException(final MissingServletRequestParameterException e) {
        log.error(e.getMessage());
        List<DetalleErrorChallenge> detalles = new ArrayList<>();
        detalles.add(DetalleErrorChallenge
                .builder()
                .objetivo(e.getParameterName())
                .mensaje(String.format("Se espera parametro %s, del tipo: %s",e.getParameterName(), e.getParameterType()))
                .build());

        ErrorChallenge errorChallenge = ErrorChallenge.builder()
                .codigoError(ErrorPrecios.PETICION_INCORRECTA.getCodigoError())
                .mensaje("Error de petición")
                .detalles(detalles)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorChallenge);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    private ErrorChallenge handleException(final Exception e) {
        log.error(e.getMessage());
        return ErrorChallenge.builder()
                .codigoError(ErrorPrecios.ERROR_GENERICO.getCodigoError())
                .mensaje("Error desconocido")
                .detalles(new ArrayList<>())
                .build();
    }

}
