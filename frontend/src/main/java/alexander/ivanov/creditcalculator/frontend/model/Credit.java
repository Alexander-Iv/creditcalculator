package alexander.ivanov.creditcalculator.frontend.model;

import java.util.ArrayList;
import java.util.List;

public class Credit {
    private Long creditId;
    private Integer creditAmount;
    private Integer creditTime;
    private InterestRate interestRate;
    private List<CreditCalcInfo> creditCalcInfos = new ArrayList<>();

    public Credit() {
    }

    public Credit(Long creditId, Integer creditAmount, Integer creditTime, InterestRate interestRate, List<CreditCalcInfo> creditCalcInfos) {
        this.creditId = creditId;
        this.creditAmount = creditAmount;
        this.creditTime = creditTime;
        this.interestRate = interestRate;
        this.creditCalcInfos = creditCalcInfos;
    }

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public Integer getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Integer creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Integer getCreditTime() {
        return creditTime;
    }

    public void setCreditTime(Integer creditTime) {
        this.creditTime = creditTime;
    }

    public InterestRate getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(InterestRate interestRate) {
        this.interestRate = interestRate;
    }

    public List<CreditCalcInfo> getCreditCalcInfos() {
        return creditCalcInfos;
    }

    public void setCreditCalcInfos(List<CreditCalcInfo> creditCalcInfos) {
        this.creditCalcInfos = creditCalcInfos;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "creditId=" + creditId +
                ", creditAmount=" + creditAmount +
                ", creditTime=" + creditTime +
                ", interestRate=" + interestRate +
                '}';
    }
}
