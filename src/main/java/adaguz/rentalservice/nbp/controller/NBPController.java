package adaguz.rentalservice.nbp.controller;

import adaguz.rentalservice.nbp.model.Result;
import adaguz.rentalservice.nbp.service.NBPService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nbp")
public class NBPController {
    private final NBPService nbpService;

    public NBPController(NBPService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping(value = "/{currency}/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> calculateRootForCurrency(@PathVariable String currency, @RequestParam(defaultValue = "1") int numberOfDays){
        return ResponseEntity.ok(nbpService.calculateRootForCurrency(currency, numberOfDays));
    }
}
