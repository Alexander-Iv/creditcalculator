package alexander.ivanov.creditcalculator.backend.controller;

import alexander.ivanov.creditcalculator.backend.service.InterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/interest-rates")
@RestController
public class InterestRateController {
    private InterestRateService interestRateService;

    @Autowired
    public InterestRateController(InterestRateService interestRateService) {
        this.interestRateService = interestRateService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(interestRateService.getInterestRates());
    }

    @GetMapping("/{rate}")
    public ResponseEntity<?> getInterestRateByRate(@PathVariable String rate) {
        try {
            Double parseRate = Double.parseDouble(rate);
            return ResponseEntity.ok(interestRateService.getInterestRateBy(parseRate));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
