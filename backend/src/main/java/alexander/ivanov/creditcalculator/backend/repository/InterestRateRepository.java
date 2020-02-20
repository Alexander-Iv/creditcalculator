package alexander.ivanov.creditcalculator.backend.repository;

import alexander.ivanov.creditcalculator.backend.model.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterestRateRepository extends JpaRepository<InterestRate, Long> {
    Optional<InterestRate> findByInterestRate(Double interestRate);
}
