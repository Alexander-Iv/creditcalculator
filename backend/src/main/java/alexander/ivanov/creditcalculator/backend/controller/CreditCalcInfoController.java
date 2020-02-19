package alexander.ivanov.creditcalculator.backend.controller;

import alexander.ivanov.creditcalculator.backend.service.CreditCalcInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/credit-calc-info")
@RestController
public class CreditCalcInfoController {
    private CreditCalcInfoService creditCalcInfoService;

    @Autowired
    public CreditCalcInfoController(CreditCalcInfoService creditCalcInfoService) {
        this.creditCalcInfoService = creditCalcInfoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok("");
    }
}
