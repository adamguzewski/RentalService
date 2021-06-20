package adaguz.rentalservice.controller;

import adaguz.rentalservice.model.Movie;
import adaguz.rentalservice.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentalservice")
public class RentalServiceController {

    private final RentalService rentalService;

    public RentalServiceController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
        }

    @PutMapping("/returnmovie/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable Long id) {
        rentalService.returnMovie(id);
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/rentmovie/{id}")
    public ResponseEntity<Movie> rentMovie(@PathVariable Long id) {
        rentalService.rentMovie(id);
        return ResponseEntity.ok(rentalService.getMovie(id));
    }
}
