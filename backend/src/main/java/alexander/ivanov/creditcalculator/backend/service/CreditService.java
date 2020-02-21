package alexander.ivanov.creditcalculator.backend.service;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.InterestRate;
import alexander.ivanov.creditcalculator.backend.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
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
        setInterestRateIfExists(credit);
        return creditRepository.saveAndFlush(credit);
    }

    public Credit selectOrInsertIfNonExists(Credit credit) {
        System.out.println("CreditService.selectOrInsertIfNonExists");
        Credit loadedCredit;
        if (!creditRepository.exists(Example.of(credit))) {
            System.out.println("!Exists");
            loadedCredit = insertCredit(credit);
        } else {
            System.out.println("!Not Exists");
            loadedCredit = selectCredit(credit);
        }
        System.out.println("loadedCredit = " + loadedCredit);

        return loadedCredit;
    }

    public Credit selectCredit(Credit credit) {
        System.out.println("CreditService.selectCredit");
        System.out.println("credit = " + credit);

        setInterestRateIfExists(credit);

        Credit findOne = creditRepository.findOne(Example.of(credit))
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        System.out.println("findOne = " + findOne);

        return findOne;
    }

    private void setInterestRateIfExists(Credit credit) {
        InterestRate loadedInterestRate = interestRateService.selectInterestRateBy(credit.getInterestRate().getInterestRate());
        System.out.println("loadedInterestRate = " + loadedInterestRate);
        if (Objects.nonNull(loadedInterestRate)) {
            credit.setInterestRate(loadedInterestRate);
        }
    }
}
