package alexander.ivanov.creditcalculator.backend.model.dto;

public class InterestRateDto {
    private String interestRateId;
    private String interestRate;

    public InterestRateDto() {
    }

    public String getInterestRateId() {
        return interestRateId;
    }

    public void setInterestRateId(String interestRateId) {
        this.interestRateId = interestRateId;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "InterestRateDto{" +
                "interestRateId='" + interestRateId + '\'' +
                ", interestRate='" + interestRate + '\'' +
                '}';
    }
}
