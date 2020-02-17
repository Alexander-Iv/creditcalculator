package alexander.ivanov.creditcalculator.backend;

import alexander.ivanov.creditcalculator.backend.util.CalculatorUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BackendApplication.class, args);

        CalculatorUtils.calcMonthlyPayment(100_000, 12, 12.9);
    }

}
