package alexander.ivanov.creditcalculator.backend.repository;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    Credit findByCreditAmountAndCreditTimeAndInterestRate(Integer creditAmount, Integer creditTime, InterestRate interestRate);
}
