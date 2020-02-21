package alexander.ivanov.creditcalculator.frontend.model;

import java.util.List;

public class CreditCalcInfos {
    private List<CreditCalcInfo> creditCalcInfos;

    public CreditCalcInfos() {
    }

    public CreditCalcInfos(List<CreditCalcInfo> creditCalcInfos) {
        this.creditCalcInfos = creditCalcInfos;
    }

    public List<CreditCalcInfo> getCreditCalcInfos() {
        return creditCalcInfos;
    }

    public void setCreditCalcInfos(List<CreditCalcInfo> creditCalcInfos) {
        this.creditCalcInfos = creditCalcInfos;
    }

    @Override
    public String toString() {
        return "CreditCalcInfos{" +
                "creditCalcInfos=" + creditCalcInfos +
                '}';
    }
}
