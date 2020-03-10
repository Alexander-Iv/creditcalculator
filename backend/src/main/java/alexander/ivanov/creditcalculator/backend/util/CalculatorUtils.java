package alexander.ivanov.creditcalculator.backend.util;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.CreditCalcInfo;
import alexander.ivanov.creditcalculator.backend.model.InterestRate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalUnit;
import java.util.*;

public class CalculatorUtils {
    private static final int SCALE_DEFAULT = 2;
    private static final int SCALE_CALC = 6;
    /**
     * Функция расчитывает ежемесячный платеж по формуле:
     * x = S * (P / (1 - (1 + P)^-N))
     * @param creditAmount сумма кредита: 100 000 - 5 000 000;
     * @param creditTime срок кредита: 12 - 60 месяцев;
     * @param annualInterestRate годовая процентная ставка: 12.9% - 23.9%.
     *
     * */
    public static Double calcMonthlyPayment(Integer creditAmount, Integer creditTime, Double annualInterestRate) {
        Double interestRateAbs = calcInterestRateAbs(annualInterestRate, 12);
        //System.out.println("interestRateAbs = " + interestRateAbs);
        //System.out.println("(1 + interestRateAbs) = " + (1 + interestRateAbs));
        //System.out.println("Math.pow(1 + interestRateAbs, creditTime) = " + round(Math.pow(1 + interestRateAbs, -creditTime)));

        Double denominator = 1 - Math.pow(1 + interestRateAbs, -creditTime);
        //System.out.println("denominator = " + denominator);

        Double result = (interestRateAbs / denominator) * creditAmount; //8 927,036
        //System.out.println("result = " + result);
        //System.out.println("Math.floor(result) = " + Math.floor(result));
        //System.out.println("Math.round(result) = " + Math.round(result));

        return round2(result);
    }

    /**
     * Функция расчитывает проентную ставку в абсолютной величине
     * @param percent процентная ставка;
     * @param monthCount количество месяцев.
     * */
    public static Double calcInterestRateAbs(Double percent, Integer monthCount) {
        return round(calcInterestRate(percent) / monthCount);
    }

    public static Double calcInterestRate(Double percent) {
        return percent / 100;
    }

    /**
     * Расчет процентной составляющей аннуитетного платежа: Pn = Sn * P / 12
     * @param balance остато задолженности на период [Sn];
     * @param annualInterestRate годовая процентная ставка по кредиту [P].
     * */
    public static Double calcInterestCharges(Double balance, Double annualInterestRate) {
        return round2(balance * calcInterestRate(annualInterestRate) / 12);
    }

    /** Часть идущая на погашение долга: S = x - Pn;
     * s - часть выплаты, идущая на погашение долга;
     * @param monthlyPayment месячный платеж [x];
     * @param interestCharges начисленные проценты, на момент n-ой выплаты [Pn]
     * */
    public static Double debtRepaymentPortion(Double monthlyPayment, Double interestCharges) {
        return round(monthlyPayment - interestCharges);
    }

    public static Credit fillCreditCalcInfos(Credit credit) {
        return fillCreditCalcInfos(credit, Date.from(Instant.now()));
    }

    public static Credit fillCreditCalcInfos(Credit credit, Date startDate) {
        List<CreditCalcInfo> creditCalcInfos = new ArrayList<>();

        Credit copyCredit = new Credit();
        copyCredit.setCreditId(credit.getCreditId());
        copyCredit.setCreditAmount(credit.getCreditAmount());
        copyCredit.setCreditTime(credit.getCreditTime());
        copyCredit.setInterestRate(credit.getInterestRate());

        List<Double> portions = new ArrayList<>();
        Double debt = Double.valueOf(credit.getCreditAmount());
        for (int i = credit.getCreditTime(); i > 0; i--) {
            Double monthlyPayment = CalculatorUtils.calcMonthlyPayment(credit.getCreditAmount(), credit.getCreditTime(), credit.getInterestRate().getInterestRate());
            Double interestRateAbs = CalculatorUtils.calcInterestRateAbs(credit.getInterestRate().getInterestRate(), 12);
            Double interestCharges = CalculatorUtils.calcInterestCharges(debt, credit.getInterestRate().getInterestRate());
            Double debtRepaymentPortion = CalculatorUtils.debtRepaymentPortion(monthlyPayment, interestCharges);

            debt -= debtRepaymentPortion;
            portions.add(debtRepaymentPortion);

            Double total = portions.stream().mapToDouble(aDouble -> aDouble).sum();

            /*Instant startDateInstant = startDate.toInstant();
            LocalDateTime localStartDate = LocalDateTime.ofInstant(startDateInstant, ZoneId.systemDefault());*/
            LocalDateTime localStartDate = DateUtils.toLocalDateTime(startDate);

            int paymentNum = credit.getCreditTime() - i;

            CreditCalcInfo creditCalcInfo = new CreditCalcInfo(
                    null,
                    paymentNum+1,
                    monthlyPayment,
                    //localStartDate.plusMonths(paymentNum).format(DateTimeFormatter.ofPattern("MM/yyyy")),
                    DateUtils.toPeriod(localStartDate, paymentNum),
                    debtRepaymentPortion,
                    interestCharges,
                    CalculatorUtils.round2(debt),
                    CalculatorUtils.round2(total),
                    credit
            );

            System.out.println(creditCalcInfo);
            creditCalcInfos.add(creditCalcInfo);
        }

        //credit.getCreditCalcInfos().clear();
        //credit.setCreditCalcInfos(creditCalcInfos);
        copyCredit.setCreditCalcInfos(creditCalcInfos);

        //return credit.getCreditCalcInfos();
        return copyCredit;
    }

    public static void printCreditCalcInfos(List<CreditCalcInfo> creditCalcInfos) {
        creditCalcInfos.forEach(creditCalcInfo -> {
            System.out.println("creditCalcInfo = " + creditCalcInfo);
        });
    }

    public static void printCreditRepaymentGraph(Date startDate, Integer creditAmount, Integer creditTime, Double annualInterestRate) {
        Credit credit = new Credit(
                null,
                creditAmount,
                creditTime,
                new InterestRate(annualInterestRate),
                Collections.emptyList()
        );

        fillCreditCalcInfos(credit, startDate).getCreditCalcInfos().forEach(creditCalcInfo -> {
            String format = String.format("paymentNum = %10s, " +
                            "monthlyPayment = %10s " +
                            "mm/yyyy = %10s " +
                            //"interestRateAbs = %10s " +
                            "interestCharges = %10s " +
                            //"debtRepaymentPortion = %10s, " +
                            "debt = %10s, " +
                            "total = %10s",
                    creditCalcInfo.getPaymentNum(),
                    creditCalcInfo.getMonthlyPayment(),
                    creditCalcInfo.getPeriod(),
                    //interestRateAbs,
                    creditCalcInfo.getInterestCharges(),
                    //debtRepaymentPortion,
                    creditCalcInfo.getDebtBalance(),
                    creditCalcInfo.getTotalPaymentAmount());
            System.out.println(format);
        });

        /*List<Double> portions = new ArrayList<>();
        Double debt = Double.valueOf(creditAmount);
        System.out.println("debt = " + debt);
        for (int i = creditTime; i > 0; i--) {
            Double monthlyPayment = CalculatorUtils.calcMonthlyPayment(creditAmount, creditTime, annualInterestRate);
            Double interestRateAbs = CalculatorUtils.calcInterestRateAbs(annualInterestRate, 12);
            Double interestCharges = CalculatorUtils.calcInterestCharges(debt, annualInterestRate);
            Double debtRepaymentPortion = CalculatorUtils.debtRepaymentPortion(monthlyPayment, interestCharges);

            debt -= debtRepaymentPortion;
            portions.add(debtRepaymentPortion);

            Double total = portions.stream().mapToDouble(aDouble -> aDouble).sum();

            Instant startDateInstant = startDate.toInstant();

            LocalDateTime localStartDate = LocalDateTime.ofInstant(startDateInstant, ZoneId.systemDefault());

            String format = String.format("paymentNum = %10s, " +
                            "monthlyPayment = %10s " +
                            "mm/yyyy = %10s " +
                            "interestRateAbs = %10s " +
                            "interestCharges = %10s " +
                            "debtRepaymentPortion = %10s, " +
                            "debt = %10s, " +
                            "total = %10s",
                    (creditTime - i)+1,
                    monthlyPayment,
                    localStartDate.plusMonths((creditTime - i)).format(DateTimeFormatter.ofPattern("MM/yyyy")),
                    interestRateAbs,
                    interestCharges,
                    debtRepaymentPortion,
                    CalculatorUtils.round2(debt),
                    CalculatorUtils.round2(total));
            System.out.println(format);
        }*/
    }

    public static Double round2(Double value) {
        return round(value, SCALE_DEFAULT);
    }

    private static Double round(Double value) {
        return round(value, SCALE_CALC);
    }

    private static double round(double value, int newScale) {
        if (newScale < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(newScale, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
