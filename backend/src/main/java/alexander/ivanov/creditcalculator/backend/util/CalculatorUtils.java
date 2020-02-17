package alexander.ivanov.creditcalculator.backend.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculatorUtils {
    private static final int DEFAULT_SCALE = 2;
    private static final MathContext MATH_CONTEXT = new MathContext(10);
    /**
     * Функция расчитывает ежемесячный платеж по формуле:
     * x = S * (P / (1 - (1 + P)^-N))
     * @param creditAmount сумма кредита: 100 000 - 5 000 000;
     * @param creditTime срок кредита: 12 - 60 месяцев;
     * @param annualInterestRate годовая процентная ставка: 12.9% - 23.9%.
     *
     * */
    public static Double calcMonthlyPayment(Integer creditAmount, Integer creditTime, Double annualInterestRate) {
        Double interestRateAbs = toFixedDouble(calcInterestRateAbs(annualInterestRate, 12));
        System.out.println("interestRateAbs = " + interestRateAbs);
        System.out.println("(1 + interestRateAbs) = " + (1 + interestRateAbs));
        System.out.println("Math.pow(1 + interestRateAbs, creditTime) = " + toFixedDouble(Math.pow(1 + interestRateAbs, -creditTime)));

        Double denominator = 1 - toFixedDouble(Math.pow(1 + interestRateAbs, -creditTime));
        System.out.println("denominator = " + denominator);

        Double result = round((interestRateAbs / denominator) * creditAmount, DEFAULT_SCALE); //8 927,036
        System.out.println("result = " + result);
        System.out.println("Math.floor(result) = " + Math.floor(result));
        System.out.println("Math.round(result) = " + Math.round(result));

        return result;
    }

    /**
     * Функция расчитывает проентную ставку в абсолютной величине
     * @param percent процентная ставка;
     * @param monthCount количество месяцев.
     * */
    public static Double calcInterestRateAbs(Double percent, Integer monthCount) {
        return calcInterestRate(percent) / monthCount;
    }

    public static Double calcInterestRate(Double percent) {
        return percent / 100;
    }

    private static Double toFixedDouble(Double value) {
        return new BigDecimal(value, MATH_CONTEXT).doubleValue();
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
