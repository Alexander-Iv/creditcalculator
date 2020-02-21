package alexander.ivanov.creditcalculator.backend.controller;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.backend.model.dto.CreditDto;
import alexander.ivanov.creditcalculator.backend.service.CreditCalcInfoService;
import alexander.ivanov.creditcalculator.backend.util.ControllerUtils;
import alexander.ivanov.creditcalculator.backend.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CreditCalcInfoController {
    private CreditCalcInfoService creditCalcInfoService;

    @Autowired
    public CreditCalcInfoController(CreditCalcInfoService creditCalcInfoService) {
        this.creditCalcInfoService = creditCalcInfoService;
    }

    @GetMapping("/credit-calc-infos")
    public ResponseEntity<?> getAll() {
        return ControllerUtils.getResponseEntity(() -> creditCalcInfoService.selectAll());
    }

    @GetMapping("/credit-calc-info")
    public ResponseEntity<?> getCreditCalcInfo(@RequestBody CreditDto creditDto) {
        return ControllerUtils.getResponseEntity(() -> {
            Credit mappedCredit = ModelMapperUtils.map(CreditDto.class, Credit.class, creditDto);
            List<CreditCalcInfo> creditCalcInfos = creditCalcInfoService.selectCreditCalcInfos(mappedCredit);
            return creditCalcInfos;
        });
    }

    @PostMapping("/credit-calc-info")
    public ResponseEntity<?> createCreditCalcInfo(@RequestBody CreditDto creditDto) {
        return ControllerUtils.getResponseEntity(() -> {
            Credit mappedCredit = ModelMapperUtils.map(CreditDto.class, Credit.class, creditDto);
            List<CreditCalcInfo> creditCalcInfos = creditCalcInfoService.insertCreditCalcInfo(mappedCredit);

            return creditCalcInfos;
        });
    }
}
