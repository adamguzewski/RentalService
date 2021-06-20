package adaguz.rentalservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import java.net.ConnectException;

@RestControllerAdvice
public class RentalServiceExceptionAdvice {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleElementNotFound() {
        return new ResponseEntity<>("Movie not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> handleConnectException(){
        return new ResponseEntity<>("Something wrong with other service", HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleBadRequestException(){
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> handleInternalServerError(){
        return new ResponseEntity<>("There is a problem with external service", HttpStatus.BAD_GATEWAY);
    }

}
