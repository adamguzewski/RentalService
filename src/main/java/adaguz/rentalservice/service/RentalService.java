package adaguz.rentalservice.service;

import adaguz.rentalservice.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;
    private final String movieServiceAddress;

    public RentalService(RestTemplate restTemplate, @Value("${movie.service.address}") String movieServiceAddress) {
        this.restTemplate = restTemplate;
        this.movieServiceAddress = movieServiceAddress;
    }

    public Movie getMovie(Long id) {
        String url = movieServiceAddress + id;
        Movie movie = restTemplate.getForEntity(url, Movie.class).getBody();
        return movie;
    }

    public void returnMovie(Long id) {
        String url = movieServiceAddress + "/returnmovie" + id;
        restTemplate.put(url, null);
    }

    public void rentMovie(Long id) {
        String url = movieServiceAddress + "/rentmovie" + id;
        restTemplate.put(url, null);
    }
}
