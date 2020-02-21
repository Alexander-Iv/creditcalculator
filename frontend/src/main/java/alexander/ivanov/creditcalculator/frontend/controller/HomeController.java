package alexander.ivanov.creditcalculator.frontend.controller;

import alexander.ivanov.creditcalculator.frontend.model.Credit;
import alexander.ivanov.creditcalculator.frontend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.frontend.model.CreditCalcInfos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.ServerRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class HomeController {
    private static final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public ModelAndView home(@ModelAttribute CreditCalcInfos creditCalcInfos, Model model) {
        System.out.println("HomeController.home");
        /*List<CreditCalcInfo> creditCalcInfosExample = new ArrayList<>();
        creditCalcInfosExample.add(
                new CreditCalcInfo(1L, 1, 1D, "01/2020", 1D, 1D, 1D, 1D,
                        new Credit(1L, 1, 1, new InterestRate(12.9D), Collections.emptyList()))
        );
        System.out.println("creditCalcInfos = " + creditCalcInfosExample);
        model.addAttribute("creditCalcInfos", creditCalcInfosExample);*/

        System.out.println("creditCalcInfos = " + creditCalcInfos);
        System.out.println("model = " + model);

        if (!model.containsAttribute("creditCalcInfos")) {
            model.addAttribute("creditCalcInfos", /*new ArrayList<CreditCalcInfo>()*/new CreditCalcInfo[]{});
        }

        return new ModelAndView("index.html");
    }

    @PostMapping("/")
    public ModelAndView postHome(@ModelAttribute Credit credit, Model model) throws JsonProcessingException {
        String jsonCredit = new ObjectMapper().writeValueAsString(credit);
        System.out.println("jsonCredit = " + jsonCredit);

        /*HttpHeaders httpHeaders = HttpHeaders.EMPTY;
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);*/

        HttpEntity<String> creditHttpEntity = new HttpEntity<>(jsonCredit/*, httpHeaders*/);
        System.out.println("creditHttpEntity = " + creditHttpEntity);
        System.out.println("creditHttpEntity = " + creditHttpEntity.getBody());

        /*ResponseEntity<CreditCalcInfos> creditCalcInfos = restTemplate.exchange("http://localhost:8080/api/credit-calc-info",
                HttpMethod.POST,
                *//*new HttpEntity<>(jsonCredit)*//*creditHttpEntity,
                CreditCalcInfos.class
                //new ParameterizedTypeReference<List<CreditCalcInfo>>() {}
                *//*ParameterizedTypeReference.forType(new Type() {
                    @Override
                    public String getTypeName() {
                        return new ArrayList<CreditCalcInfo>().toString();
                    }
                })*//*
        );*/
        /*ResponseEntity<CreditCalcInfos> creditCalcInfos =
                restTemplate.postForEntity("http://localhost:8080/api/credit-calc-info", jsonCredit, CreditCalcInfos.class);*/
        /*ResponseEntity<CreditCalcInfos> creditCalcInfos = restTemplate.execute("http://localhost:8080/api/credit-calc-info",
                HttpMethod.POST,
                restTemplate.acceptHeaderRequestCallback(credit.getClass()),
                //restTemplate.httpEntityCallback(credit),
                restTemplate.responseEntityExtractor(new Type() {
                    @Override
                    public String getTypeName() {
                        return CreditCalcInfos.class.getTypeName();
                    }
                })
        );*/
        /*CreditCalcInfos creditCalcInfos = restTemplate.postForObject(
                "http://localhost:8080/api/credit-calc-info",
                credit,
                CreditCalcInfos.class
        );*/

        HttpEntity<Credit> requestEntity = new HttpEntity<>(credit);
        System.out.println("requestEntity = " + requestEntity);
        requestEntity.getHeaders().forEach((s, strings) -> {
            System.out.println("s + s2 = " + s + " s2 = " + strings);
        });

        ResponseEntity<CreditCalcInfos> creditCalcInfos = restTemplate.exchange(
                "http://localhost:8080/api/credit-calc-info",
                HttpMethod.POST,
                requestEntity,
                CreditCalcInfos.class
        );

        System.out.println("creditCalcInfos = " + creditCalcInfos);
        model.addAttribute("creditCalcInfos", creditCalcInfos);

        /*System.out.println("responseInfos = " + responseInfos);
        List<CreditCalcInfo> infos = responseInfos.getBody();
        System.out.println("infos = " + infos);*/

        //CreditCalcInfos infos = responseInfos.getBody();
        /*if (infos != null) {
            infos.getCreditCalcInfos().forEach(creditCalcInfo -> {
                System.out.println("!creditCalcInfo = " + creditCalcInfo);
            });
        }*/

        /*if (infos != null) {
            model.addAttribute("creditCalcInfos", new CreditCalcInfos(infos));
        }*/

        return new ModelAndView("index.html");
    }

    @ModelAttribute("creditCalcInfos")
    public CreditCalcInfos getCreditCalcInfos() {
        return new CreditCalcInfos(Collections.emptyList());
    }

    @ModelAttribute("credit")
    public Credit getCredit() {
        return new Credit();
    }
}
