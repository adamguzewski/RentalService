package adaguz.rentalservice.controller;

import adaguz.rentalservice.model.Movie;
import adaguz.rentalservice.service.RentalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentalservice")
public class RentalServiceController {

    private final RentalService rentalService;

    public RentalServiceController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @ApiOperation(value = "Get movie with specific ID.",
            response = Movie.class,
            notes = "This method returns movie with specific ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Movie Not Found"),
            @ApiResponse(code = 500, message = "Movie Not Found"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(
            @ApiParam(name = "id",
                    type = "long",
                    example = "3",
                    required = true,
                    defaultValue = "3")
            @PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @ApiOperation(value = "Changing availability to true of movie with specific id.",
            response = Movie.class,
            notes = "This method changes status of movie to true.")
    @PutMapping("/returnmovie/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable Long id) {
        rentalService.returnMovie(id);
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @ApiOperation(value = "Changing availability to false of movie with specific id.",
            response = Movie.class,
            notes = "This method changes status of movie to false.")
    @PutMapping("/rentmovie/{id}")
    public ResponseEntity<Movie> rentMovie(@PathVariable Long id) {
        rentalService.rentMovie(id);
        return ResponseEntity.ok(rentalService.getMovie(id));
    }
}
