package alexander.ivanov.creditcalculator.frontend.controller;

import alexander.ivanov.creditcalculator.frontend.model.Credit;
import alexander.ivanov.creditcalculator.frontend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.frontend.model.CreditCalcInfos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.net.WriteBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@CrossOrigin
@RestController
public class HomeController {
    private RestTemplate backend = new RestTemplate();
    /*new RestTemplateBuilder()
            .rootUri("http://localhost:8080")
            .build();*/

    /*@Autowired
    public HomeController(RestTemplate restTemplate) {
        this.backend = restTemplate;
    }*/

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
        //String jsonCredit = new ObjectMapper().writeValueAsString(credit);
        String jsonCredit = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(credit);
        System.out.println("jsonCredit = " + jsonCredit);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> creditHttpEntity = new HttpEntity<>(jsonCredit, httpHeaders);
        System.out.println("creditHttpEntity = " + creditHttpEntity);
        System.out.println("creditHttpEntity = " + creditHttpEntity.getBody());

        HttpEntity<?> requestEntity = new HttpEntity<>(jsonCredit);
        System.out.println("requestEntity = " + requestEntity);
        requestEntity.getHeaders().forEach((s, strings) -> {
            System.out.println("s + s2 = " + s + " s2 = " + strings);
        });
        System.out.println("requestEntity.getBody() = " + requestEntity.getBody());

        /*ResponseEntity<?> result = backend.exchange("http://backend:8080/api/credits", HttpMethod.GET, null, String.class);
        System.out.println("result.getBody() = " + result.getBody());
        System.out.println("backend = " + backend);*/

        CreditCalcInfo[] creditCalcInfos = backend.postForObject(
                URI.create("http://backend:8080/api/credit-calc-info"),
                creditHttpEntity,
                CreditCalcInfo[].class
        );

        if (creditCalcInfos != null) {
            System.out.println("creditCalcInfos = " + Arrays.asList(creditCalcInfos));
        }
        model.addAttribute("creditCalcInfos", new CreditCalcInfos(creditCalcInfos));

        return new ModelAndView("index.html");
    }

    @ModelAttribute("creditCalcInfos")
    public CreditCalcInfos getCreditCalcInfos() {
        //return new CreditCalcInfos(Collections.emptyList());
        return new CreditCalcInfos(new CreditCalcInfo[]{});
    }

    @ModelAttribute("credit")
    public Credit getCredit() {
        return new Credit();
    }
}
