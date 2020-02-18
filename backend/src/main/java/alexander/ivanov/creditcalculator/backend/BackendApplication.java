package alexander.ivanov.creditcalculator.backend;

import alexander.ivanov.creditcalculator.backend.util.CalculatorUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        System.getenv().forEach((s, s2) -> {
            System.out.println(String.format("%-25s=%s", s, s2));
        });

        SpringApplication.run(BackendApplication.class, args);

        Integer CREDIT_AMOUNT = 100_000;
        Integer CREDIT_TIME = 12;
        Double ANNUAL_INTEREST_RATE = 12.9;
        Date startDate = Date.from(Instant.now());

        CalculatorUtils.printCreditRepaymentGraph(startDate, CREDIT_AMOUNT, CREDIT_TIME, ANNUAL_INTEREST_RATE);
    }
}
