package alexander.ivanov.creditcalculator.frontend.controller;

import alexander.ivanov.creditcalculator.frontend.model.Credit;
import alexander.ivanov.creditcalculator.frontend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.frontend.model.CreditCalcInfos;
import alexander.ivanov.creditcalculator.frontend.model.InterestRate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public ModelAndView home(@ModelAttribute Credit credit, Model model) {
        System.out.println("HomeController.home");
        List<CreditCalcInfo> creditCalcInfosExample = new ArrayList<>();
        creditCalcInfosExample.add(
                new CreditCalcInfo(1L, 1, 1D, "01/2020", 1D, 1D, 1D, 1D,
                        new Credit(1L, 1, 1, new InterestRate(12.9D), Collections.emptyList()))
        );
        System.out.println("creditCalcInfos = " + creditCalcInfosExample);
        model.addAttribute("creditCalcInfos", creditCalcInfosExample);

        return new ModelAndView("index.html");
    }

    @ModelAttribute("creditCalcInfos")
    public CreditCalcInfos getCreditCalcInfos() {
        return new CreditCalcInfos();
    }
}
