package alexander.ivanov.creditcalculator.backend.service;

import alexander.ivanov.creditcalculator.backend.model.InterestRate;
import alexander.ivanov.creditcalculator.backend.repository.InterestRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestRateService {
    private InterestRateRepository interestRateRepository;

    @Autowired
    public InterestRateService(InterestRateRepository interestRateRepository) {
        this.interestRateRepository = interestRateRepository;
    }

    public List<InterestRate> getInterestRates() {
        return interestRateRepository.findAll();
    }

    public InterestRate getInterestRateBy(Double interestRate) {
        return interestRateRepository
                .findByInterestRate(interestRate)
                .orElseThrow(() -> new RuntimeException("No data found"));
    }
}
