package alexander.ivanov.creditcalculator.backend.service;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.backend.repository.CreditCalcInfoRepository;
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

    public List<CreditCalcInfo> selectAll() {
        return creditCalcInfoRepository.findAll();
    }

    public List<CreditCalcInfo> selectAllByCredit(Credit credit) {
        return creditCalcInfoRepository.findAllByCredit(credit);
    }
}
