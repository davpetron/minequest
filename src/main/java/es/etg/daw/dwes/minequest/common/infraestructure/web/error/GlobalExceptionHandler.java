package es.etg.daw.dwes.minequest.common.infraestructure.web.error;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.ErrorResponse;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import es.etg.daw.dwes.minequest.tarea.domain.error.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validationHandler(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getAllErrors().stream()
                .map(e -> (e instanceof FieldError fe ? fe.getField() : e.getObjectName())
                        + ": " + e.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return build(HttpStatus.BAD_REQUEST, msg);
    }

    @ExceptionHandler({ IllegalArgumentException.class, HttpMessageNotReadableException.class })
    public ResponseEntity<String> badRequestHandler(Exception ex) {
        return build(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> typeMismatchHandler(MethodArgumentTypeMismatchException ex) {
        return build(HttpStatus.BAD_REQUEST, "El parámetro %s debe ser un número".formatted(ex.getName()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> notFoundHandler(EntityNotFoundException ex) {
        return build(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullPointerHandler(NullPointerException ex) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> genericHandler(Exception ex) {
        if (ex instanceof ErrorResponse er) {
            HttpStatus status = HttpStatus.valueOf(er.getStatusCode().value());
            String msg = switch (status) {
                case NOT_FOUND -> "La ruta solicitada no existe";
                default -> "Petición no válida";
            };
            return build(status, msg);
        }
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
    }

    private ResponseEntity<String> build(HttpStatus status, String message) {
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), status, message);
        return ResponseEntity
                .status(cr.getStatus())
                .contentType(MediaType.TEXT_HTML)
                .body(buildErrorHtml(cr));
    }

    private String buildErrorHtml(CustomResponse cr) {
        return """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <title>Error</title>
                </head>
                <body>
                    <div class="card">
                        <h1>Se ha producido un error</h1>
                        <dl>
                            <dt>Fecha</dt>   <dd>%s</dd>
                            <dt>Código</dt>  <dd>%s - %s</dd>
                            <dt>Mensaje</dt> <dd>%s</dd>
                        </dl>
                    </div>
                </body>
                </html>
                """.formatted(
                escapeHtml(String.valueOf(cr.getDate())),
                cr.getStatus().value(),
                escapeHtml(cr.getStatus().getReasonPhrase()),
                escapeHtml(cr.getMessage()));
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}