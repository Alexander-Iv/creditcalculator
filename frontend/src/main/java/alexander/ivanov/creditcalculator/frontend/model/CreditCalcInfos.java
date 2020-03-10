package alexander.ivanov.creditcalculator.frontend.model;

import java.util.List;

public class CreditCalcInfos {
    /*private List<CreditCalcInfo> creditCalcInfos;

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
    }*/

    private CreditCalcInfo[] creditCalcInfos;

    public CreditCalcInfos(CreditCalcInfo[] creditCalcInfos) {
        this.creditCalcInfos = creditCalcInfos;
    }

    public CreditCalcInfo[] getCreditCalcInfos() {
        return creditCalcInfos;
    }

    public void setCreditCalcInfos(CreditCalcInfo[] creditCalcInfos) {
        this.creditCalcInfos = creditCalcInfos;
    }
}
