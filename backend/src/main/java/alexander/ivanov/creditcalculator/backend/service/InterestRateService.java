package alexander.ivanov.creditcalculator.backend.service;

import alexander.ivanov.creditcalculator.backend.model.InterestRate;
import alexander.ivanov.creditcalculator.backend.repository.InterestRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class InterestRateService {
    private InterestRateRepository interestRateRepository;

    @Autowired
    public InterestRateService(InterestRateRepository interestRateRepository) {
        this.interestRateRepository = interestRateRepository;
    }

    public List<InterestRate> selectInterestRates() {
        return interestRateRepository.findAll();
    }

    public InterestRate selectInterestRateBy(Double interestRate) {
        return interestRateRepository
                .findByInterestRate(interestRate)
                .orElseThrow(() -> new RuntimeException("Interest rate not found"));
    }
}
