package adaguz.rentalservice.controller;

import adaguz.rentalservice.service.RentalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rentalservice")
public class RentalServiceController {

    private final RentalService rentalService;

    public RentalServiceController(RentalService rentalService) {
        this.rentalService = rentalService;
    }



}
