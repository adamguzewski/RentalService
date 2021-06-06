package adaguz.rentalservice.service;

import adaguz.rentalservice.model.Movie;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        Movie movie = restTemplate.getForEntity("http://localhost:8080/movies/" + id, Movie.class).getBody();
        return movie;
    }


    public void returnMovie(Long id){
        restTemplate.put("http://localhost:8080/movies/update/" + id, Movie.class);
    }

}
