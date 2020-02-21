package alexander.ivanov.creditcalculator.frontend.model;

public class InterestRate {
    private Long interestRateId;

    private Double interestRate;

    public InterestRate() {
    }

    public InterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Long getInterestRateId() {
        return interestRateId;
    }

    public void setInterestRateId(Long interestRateId) {
        this.interestRateId = interestRateId;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "InterestRate{" +
                "interestRateId=" + interestRateId +
                ", interestRate=" + interestRate +
                '}';
    }
}
