package alexander.ivanov.creditcalculator.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCalcInfoDto {
    private String creditCalcInfoId;
    private String paymentNum;
    private String monthlyPayment;
    private String period;
    private String debtRepaymentPortion;
    private String interestCharges;
    private String debtBalance;
    private String totalPaymentAmount;
    @JsonProperty("credit")
    private CreditDto creditDto;

    public CreditCalcInfoDto() {
    }

    public String getCreditCalcInfoId() {
        return creditCalcInfoId;
    }

    public void setCreditCalcInfoId(String creditCalcInfoId) {
        this.creditCalcInfoId = creditCalcInfoId;
    }

    public String getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(String paymentNum) {
        this.paymentNum = paymentNum;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDebtRepaymentPortion() {
        return debtRepaymentPortion;
    }

    public void setDebtRepaymentPortion(String debtRepaymentPortion) {
        this.debtRepaymentPortion = debtRepaymentPortion;
    }

    public String getInterestCharges() {
        return interestCharges;
    }

    public void setInterestCharges(String interestCharges) {
        this.interestCharges = interestCharges;
    }

    public String getDebtBalance() {
        return debtBalance;
    }

    public void setDebtBalance(String debtBalance) {
        this.debtBalance = debtBalance;
    }

    public String getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(String totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public CreditDto getCreditDto() {
        return creditDto;
    }

    public void setCreditDto(CreditDto creditDto) {
        this.creditDto = creditDto;
    }

    @Override
    public String toString() {
        return "CreditCalcInfoDto{" +
                "creditCalcInfoId='" + creditCalcInfoId + '\'' +
                ", paymentNum='" + paymentNum + '\'' +
                ", monthlyPayment='" + monthlyPayment + '\'' +
                ", period='" + period + '\'' +
                ", debtRepaymentPortion='" + debtRepaymentPortion + '\'' +
                ", interestCharges='" + interestCharges + '\'' +
                ", debtBalance='" + debtBalance + '\'' +
                ", totalPaymentAmount='" + totalPaymentAmount + '\'' +
                ", creditDto=" + creditDto +
                '}';
    }
}
