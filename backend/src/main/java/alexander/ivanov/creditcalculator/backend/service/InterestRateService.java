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
        /*return Stream.of(interestRateRepository.findAll())
                .map(Iterable::iterator)
                .filter(Iterator::hasNext)
                .map(Iterator::next)
                .peek(interestRate -> {
                    System.out.println("interestRate = " + interestRate);
                })
                .collect(Collectors.toList());*/
        /*List<InterestRate> interestRates = new ArrayList<>();
        interestRateRepository.findAll().forEach(interestRate -> {
            System.out.println("interestRate = " + interestRate);
            interestRates.add(interestRate);
        });*/
        return interestRateRepository.findAll();
    }

    public InterestRate getInterestRateBy(Double interestRate) {
        return interestRateRepository
                .findByInterestRate(interestRate)
                .orElseThrow(() -> new RuntimeException("No data found"));
    }
}
