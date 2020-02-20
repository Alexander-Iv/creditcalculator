package alexander.ivanov.creditcalculator.backend.service;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.InterestRate;
import alexander.ivanov.creditcalculator.backend.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CreditService {
    private CreditRepository creditRepository;
    private InterestRateService interestRateService;

    @Autowired
    public CreditService(CreditRepository creditRepository, InterestRateService interestRateService) {
        this.creditRepository = creditRepository;
        this.interestRateService = interestRateService;
    }

    public List<Credit> selectCredits() {
        return creditRepository.findAll();
    }

    public Credit insertCredit(Credit credit) {
        System.out.println("CreditService.insertCredit");
        System.out.println("credit = " + credit);

        Credit loadedCredit = selectCredit(credit);
        if (Objects.isNull(loadedCredit)) {
            return creditRepository.save(credit);
        } else {
            return loadedCredit;
        }
    }

    @Transactional
    public Credit selectCredit(Credit credit) {
        System.out.println("CreditService.selectCredit");
        System.out.println("credit = " + credit);

        InterestRate loadedInterestRate = interestRateService.getInterestRateBy(credit.getInterestRate().getInterestRate());
        System.out.println("loadedInterestRate = " + loadedInterestRate);
        credit.setInterestRate(loadedInterestRate);

        return creditRepository.findByCreditAmountAndCreditTimeAndInterestRate(credit.getCreditAmount(), credit.getCreditTime(), credit.getInterestRate());
    }
}
