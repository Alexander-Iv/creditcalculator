package alexander.ivanov.creditcalculator.backend.controller;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.dto.CreditDto;
import alexander.ivanov.creditcalculator.backend.service.CreditService;
import alexander.ivanov.creditcalculator.backend.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class CreditController {
    private CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/credits")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(creditService.selectCredits());
    }

    @GetMapping("/credit")
    public ResponseEntity<?> getCredit(@RequestBody CreditDto creditDto) {
        System.out.println("CreditController.getCredit");
        System.out.println("creditDto = " + creditDto);

        Credit credit = null;
        try {
            Credit mappedCredit = ModelMapperUtils.map(CreditDto.class, Credit.class, creditDto);

            System.out.println("mappedCredit = " + mappedCredit);
            System.out.println("credit = " + credit);

            credit = creditService.selectCredit(mappedCredit);
            return ResponseEntity.ok(credit);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/credit")
    public ResponseEntity<?> createCredit(@RequestBody CreditDto creditDto) {
        System.out.println("CreditController.createCredit");
        System.out.println("creditDto = " + creditDto);

        Credit credit = null;
        try {
            Credit mappedCredit = ModelMapperUtils.map(CreditDto.class, Credit.class, creditDto);

            System.out.println("mappedCredit = " + mappedCredit);
            credit = creditService.insertCredit(mappedCredit);

            System.out.println("credit = " + credit);
            return ResponseEntity.ok(credit);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
