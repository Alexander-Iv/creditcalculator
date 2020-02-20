package alexander.ivanov.creditcalculator.backend.service;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.backend.repository.CreditCalcInfoRepository;
import alexander.ivanov.creditcalculator.backend.util.CalculatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreditCalcInfoService {
    private CreditCalcInfoRepository creditCalcInfoRepository;

    @Autowired
    public CreditCalcInfoService(CreditCalcInfoRepository creditCalcInfoRepository) {
        this.creditCalcInfoRepository = creditCalcInfoRepository;
    }

    @Transactional
    public List<CreditCalcInfo> insertCreditCalcInfo(Credit credit) {
        List<CreditCalcInfo> creditCalcInfos = CalculatorUtils.fillCreditCalcInfos(credit);
        CalculatorUtils.printCreditCalcInfos(creditCalcInfos);
        /*creditCalcInfos.forEach(creditCalcInfo -> {
            creditCalcInfoRepository.save(creditCalcInfo);
        });*/
        return creditCalcInfoRepository.saveAll(creditCalcInfos);
    }

    public List<CreditCalcInfo> selectAll() {
        return creditCalcInfoRepository.findAll();
    }

    public List<CreditCalcInfo> selectAllByCredit(Credit credit) {
        return creditCalcInfoRepository.findAllByCredit(credit);
    }
}
