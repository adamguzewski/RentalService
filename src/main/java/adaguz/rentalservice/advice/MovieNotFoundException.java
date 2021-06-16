package adaguz.rentalservice.advice;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(long id){
        super("Could not find Movie with id: " + id);
    }
}
