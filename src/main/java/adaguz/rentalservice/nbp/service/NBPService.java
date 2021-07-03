package adaguz.rentalservice.nbp.service;

import adaguz.rentalservice.nbp.model.Rate;
import adaguz.rentalservice.nbp.model.Result;
import adaguz.rentalservice.nbp.model.Root;
import adaguz.rentalservice.nbp.repository.NbpRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NBPService {
    private final RestTemplate restTemplate;
    private final NbpRepository nbpRepository;
    private final String nbpServiceAddress;

    public NBPService(RestTemplate restTemplate, NbpRepository nbpRepository,
                      @Value("${nbp.service.address}") String nbpServiceAddress) {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;
        this.nbpServiceAddress = nbpServiceAddress;
    }

    public Result calculateRootForCurrency(String currency, int numberOfDays){
        String url = nbpServiceAddress + currency + "/last/" + numberOfDays;
        Root root = restTemplate.getForObject(url, Root.class);
        double average = calculate(root.getRates());
        Result result = getResult(currency, numberOfDays, average);
        return nbpRepository.save(result);
    }

    private Result getResult(String currency, int numberOfDays, double calculate){
        Result result = new Result();
        result.setCurrency(currency);
        result.setDays(numberOfDays);
        result.setAverage(calculate);
        result.setCreationDate(LocalDateTime.now());
        return result;
    }

    private double calculate(List<Rate> rateList){
        return rateList.stream()
                .mapToDouble(Rate::getMid)
                .average()
                .orElse(0.0d);
    }

}
