package alexander.ivanov.creditcalculator.backend.controller;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.dto.CreditDto;
import alexander.ivanov.creditcalculator.backend.service.CreditService;
import alexander.ivanov.creditcalculator.backend.util.ControllerUtils;
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
        return ControllerUtils.getResponseEntity(() -> creditService.selectCredits());
    }

    @GetMapping("/credit")
    public ResponseEntity<?> getCredit(@RequestBody CreditDto creditDto) {
        System.out.println("CreditController.getCredit");
        System.out.println("creditDto = " + creditDto);

        return ControllerUtils.getResponseEntity(() -> {
            Credit mappedCredit = ModelMapperUtils.map(CreditDto.class, Credit.class, creditDto);

            System.out.println("mappedCredit = " + mappedCredit);

            Credit credit = null;
            System.out.println("credit = " + credit);
            credit = creditService.selectCredit(mappedCredit);

            return credit;
        });
    }

    @PostMapping("/credit")
    public ResponseEntity<?> createCredit(@RequestBody CreditDto creditDto) {
        System.out.println("CreditController.createCredit");
        System.out.println("creditDto = " + creditDto);

        return ControllerUtils.getResponseEntity(() -> {
            Credit mappedCredit = ModelMapperUtils.map(CreditDto.class, Credit.class, creditDto);

            System.out.println("mappedCredit = " + mappedCredit);

            Credit credit = creditService.selectOrInsertIfNonExists(mappedCredit);
            System.out.println("credit = " + credit);

            return credit;
        });
    }
}
