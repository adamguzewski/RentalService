package adaguz.rentalservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MovieNotFoundException extends RuntimeException {
    public ResponseEntity<String> MovieNotFoundException(long id){
        return new ResponseEntity<String>("Movie not found" + id, HttpStatus.NOT_FOUND);
    }
}
