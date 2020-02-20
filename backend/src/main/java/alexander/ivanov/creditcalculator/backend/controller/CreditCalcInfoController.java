package alexander.ivanov.creditcalculator.backend.controller;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.backend.model.dto.CreditDto;
import alexander.ivanov.creditcalculator.backend.service.CreditCalcInfoService;
import alexander.ivanov.creditcalculator.backend.service.CreditService;
import alexander.ivanov.creditcalculator.backend.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CreditCalcInfoController {
    private CreditCalcInfoService creditCalcInfoService;
    private CreditService creditService;

    @Autowired
    public CreditCalcInfoController(CreditCalcInfoService creditCalcInfoService, CreditService creditService) {
        this.creditCalcInfoService = creditCalcInfoService;
        this.creditService = creditService;
    }

    @GetMapping("/credit-calc-infos")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(creditCalcInfoService.selectAll());
    }

    @GetMapping("/credit-calc-info")
    public ResponseEntity<?> getCreditCalcInfo(@RequestBody CreditDto creditDto) {
        try {
            Credit mappedCredit = ModelMapperUtils.map(CreditDto.class, Credit.class, creditDto);
            Credit loadedCredit = creditService.selectCredit(mappedCredit);
            List<CreditCalcInfo> creditCalcInfos = creditCalcInfoService.selectAllByCredit(loadedCredit);

            return ResponseEntity.ok(creditCalcInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/credit-calc-info")
    public ResponseEntity<?> createCreditCalcInfo(@RequestBody CreditDto creditDto) {
        try {
            Credit mappedCredit = ModelMapperUtils.map(CreditDto.class, Credit.class, creditDto);
            Credit loadedCredit = creditService.selectCredit(mappedCredit);
            List<CreditCalcInfo> creditCalcInfos = creditCalcInfoService.insertCreditCalcInfo(loadedCredit);

            return ResponseEntity.ok(creditCalcInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
