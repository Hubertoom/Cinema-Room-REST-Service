package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = RowOrColumOutOfBoundException.class)
    public ResponseEntity<Object> handleRowOrColumnOutOfBoundException(
            RowOrColumOutOfBoundException e
    ) {
        ApiException apiException = new ApiException(
                e.getMessage()
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = TicketSoldException.class)
    public ResponseEntity<Object> handleTicketSoldException(
            TicketSoldException e
    ) {
        ApiException apiException = new ApiException(e.getMessage());

        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST
        );
    }
}
