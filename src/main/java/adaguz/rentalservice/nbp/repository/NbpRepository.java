package adaguz.rentalservice.nbp.repository;

import adaguz.rentalservice.nbp.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NbpRepository extends JpaRepository<Result, Long> {
}
