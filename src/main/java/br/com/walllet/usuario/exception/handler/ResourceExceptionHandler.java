package br.com.walllet.usuario.exception.handler;

import br.com.walllet.usuario.exception.ObjetoConsultaNotFoundException;
import br.com.walllet.usuario.exception.response.FieldMessage;
import br.com.walllet.usuario.exception.response.StandardError;
import br.com.walllet.usuario.exception.response.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjetoConsultaNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjetoConsultaNotFoundException e, HttpServletRequest request) {

        StandardError err = StandardError.builder()
                .error("Objeto não encontrado.")
                .path(request.getRequestURI())
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException,
                                                                         HttpServletRequest httpServletRequest) {

        ValidationError validationError = ValidationError.builder()
                .timestamp(System.currentTimeMillis())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Erro de validação")
                .path(httpServletRequest.getRequestURI()).build();


        validationError.setFieldMessages(methodArgumentNotValidException.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> FieldMessage.builder().fieldName(x.getField()).message(x.getDefaultMessage()).build())
                .collect(Collectors.toList()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);

    }
}
