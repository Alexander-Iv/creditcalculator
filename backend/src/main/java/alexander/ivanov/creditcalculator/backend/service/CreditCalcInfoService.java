package alexander.ivanov.creditcalculator.backend.service;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.backend.repository.CreditCalcInfoRepository;
import alexander.ivanov.creditcalculator.backend.util.CalculatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCalcInfoService {
    private CreditCalcInfoRepository creditCalcInfoRepository;

    @Autowired
    public CreditCalcInfoService(CreditCalcInfoRepository creditCalcInfoRepository) {
        this.creditCalcInfoRepository = creditCalcInfoRepository;
    }

    public List<CreditCalcInfo> insertCreditCalcInfo(Credit credit) {
        System.out.println("CreditCalcInfoService.insertCreditCalcInfo");

        Credit creditCopy = CalculatorUtils.fillCreditCalcInfos(credit);
        CalculatorUtils.printCreditCalcInfos(creditCopy.getCreditCalcInfos());

        List<CreditCalcInfo> creditCalcInfos = creditCalcInfoRepository.saveAll(creditCopy.getCreditCalcInfos());


        System.out.println("!RESULT");
        creditCalcInfos.forEach(creditCalcInfo -> {
            System.out.println("creditCalcInfo = " + creditCalcInfo);
        });

        return creditCalcInfos;

        //return creditCalcInfoRepository.saveAll(creditCalcInfos);
    }

    public List<CreditCalcInfo> selectAll() {
        return creditCalcInfoRepository.findAll();
    }

    public List<CreditCalcInfo> selectAllByCredit(Credit credit) {
        return creditCalcInfoRepository.findAllByCredit(credit);
    }
}
