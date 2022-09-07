package cardapio.app.exceptions;

import cardapio.app.exceptions.business.CardapioExistsException;
import cardapio.app.exceptions.business.CardapioNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseErrorHandler {

    @ExceptionHandler(CardapioNotExistsException.class)
    public final ResponseEntity<ErrorResponse> handleBadRequestArgument(CardapioNotExistsException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(404, ex.getMessage()));
    }

    @ExceptionHandler(CardapioExistsException.class)
    public final ResponseEntity<ErrorResponse> handleBadRequestArgument(CardapioExistsException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(409, ex.getMessage()));
    }
}
