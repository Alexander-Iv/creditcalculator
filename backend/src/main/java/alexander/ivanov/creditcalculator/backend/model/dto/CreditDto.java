package alexander.ivanov.creditcalculator.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditDto {
    private String creditId;
    private String creditAmount;
    private String creditTime;
    @JsonProperty("interestRate")
    private InterestRateDto interestRateDto;
    @JsonProperty("creditCalcInfo")
    private CreditCalcInfoDto creditCalcInfoDto;

    public CreditDto() {
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getCreditTime() {
        return creditTime;
    }

    public void setCreditTime(String creditTime) {
        this.creditTime = creditTime;
    }

    public InterestRateDto getInterestRateDto() {
        return interestRateDto;
    }

    public void setInterestRateDto(InterestRateDto interestRateDto) {
        this.interestRateDto = interestRateDto;
    }

    public CreditCalcInfoDto getCreditCalcInfoDto() {
        return creditCalcInfoDto;
    }

    public void setCreditCalcInfoDto(CreditCalcInfoDto creditCalcInfoDto) {
        this.creditCalcInfoDto = creditCalcInfoDto;
    }

    @Override
    public String toString() {
        return "CreditDto{" +
                "creditId='" + creditId + '\'' +
                ", creditAmount='" + creditAmount + '\'' +
                ", creditTime='" + creditTime + '\'' +
                ", interestRateDto=" + interestRateDto +
                '}';
    }
}
