package alexander.ivanov.creditcalculator.backend.service;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.backend.repository.CreditCalcInfoRepository;
import alexander.ivanov.creditcalculator.backend.util.CalculatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class CreditCalcInfoService {
    private CreditCalcInfoRepository creditCalcInfoRepository;
    private CreditService creditService;

    @Autowired
    public CreditCalcInfoService(CreditCalcInfoRepository creditCalcInfoRepository, CreditService creditService) {
        this.creditCalcInfoRepository = creditCalcInfoRepository;
        this.creditService = creditService;
    }

    public List<CreditCalcInfo> insertCreditCalcInfo(Credit credit) {
        System.out.println("CreditCalcInfoService.insertCreditCalcInfo");
        return selectCreditCalcInfos(credit);
    }

    public List<CreditCalcInfo> selectAll() {
        return creditCalcInfoRepository.findAll();
    }

    public List<CreditCalcInfo> selectCreditCalcInfos(Credit credit) {
        System.out.println("CreditCalcInfoService.selectCreditCalcInfos");
        Credit loadedCredit = creditService.selectOrInsertIfNonExists(credit);

        if (Objects.isNull(loadedCredit)) {
            loadedCredit = credit;
        }

        Credit filledCredit = CalculatorUtils.fillCreditCalcInfos(loadedCredit);
        CalculatorUtils.printCreditCalcInfos(filledCredit.getCreditCalcInfos());

        List<CreditCalcInfo> creditCalcInfos = selectAllByCredit(filledCredit);
        if (creditCalcInfos.isEmpty()) {
            creditCalcInfos = creditCalcInfoRepository.saveAll(filledCredit.getCreditCalcInfos());
        }

        return creditCalcInfos;
    }

    private List<CreditCalcInfo> selectAllByCredit(Credit credit) {
        return creditCalcInfoRepository.findAllByCredit(credit);
    }
}
