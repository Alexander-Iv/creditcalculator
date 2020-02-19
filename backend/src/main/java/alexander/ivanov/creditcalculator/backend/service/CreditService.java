package alexander.ivanov.creditcalculator.backend.service;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.repository.CreditRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditService {
    private CreditRepository creditRepository;

    public void addCredit(Credit credit) {
        creditRepository.save(credit);
    }
}
