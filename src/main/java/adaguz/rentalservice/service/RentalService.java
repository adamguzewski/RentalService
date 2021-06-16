package adaguz.rentalservice.service;

import adaguz.rentalservice.advice.MovieNotFoundException;
import adaguz.rentalservice.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        try {
            Movie movie = restTemplate.getForEntity("http://localhost:8080/movies/" + id, Movie.class).getBody();
            return movie;
        } catch (Exception exception) {
            throw new MovieNotFoundException(id);
        }
    }

    // Stworzyć jedną metodę zmieniającą status  wypożyczenia przez exchange
    // utworzyć zmienną zawierającą większość adresu

    public void returnMovie(Long id) {
        restTemplate.put("http://localhost:8080/movies/returnmovie/" + id, null);
    }

    public void rentMovie(Long id) {
        restTemplate.put("http://localhost:8080/movies/rentmovie/" + id, null);
    }
}
