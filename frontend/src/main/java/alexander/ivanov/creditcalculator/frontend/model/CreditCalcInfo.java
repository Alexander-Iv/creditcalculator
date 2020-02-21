package alexander.ivanov.creditcalculator.frontend.model;

public class CreditCalcInfo {
    private Long creditCalcInfoId;
    private Integer paymentNum;
    private Double monthlyPayment;
    private String period;
    private Double debtRepaymentPortion;
    private Double interestCharges;
    private Double debtBalance;
    private Double totalPaymentAmount;
    private Credit credit;

    public CreditCalcInfo() {
    }

    public CreditCalcInfo(Long creditCalcInfoId, Integer paymentNum, Double monthlyPayment, String period,
                          Double debtRepaymentPortion, Double interestCharges, Double debtBalance, Double totalPaymentAmount,
                          Credit credit) {
        this.creditCalcInfoId = creditCalcInfoId;
        this.paymentNum = paymentNum;
        this.monthlyPayment = monthlyPayment;
        this.period = period;
        this.debtRepaymentPortion = debtRepaymentPortion;
        this.interestCharges = interestCharges;
        this.debtBalance = debtBalance;
        this.totalPaymentAmount = totalPaymentAmount;
        this.credit = credit;
    }

    public Long getCreditCalcInfoId() {
        return creditCalcInfoId;
    }

    public void setCreditCalcInfoId(Long creditCalcInfoId) {
        this.creditCalcInfoId = creditCalcInfoId;
    }

    public Integer getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(Integer paymentNum) {
        this.paymentNum = paymentNum;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getDebtRepaymentPortion() {
        return debtRepaymentPortion;
    }

    public void setDebtRepaymentPortion(Double debtRepaymentPortion) {
        this.debtRepaymentPortion = debtRepaymentPortion;
    }

    public Double getInterestCharges() {
        return interestCharges;
    }

    public void setInterestCharges(Double interestCharges) {
        this.interestCharges = interestCharges;
    }

    public Double getDebtBalance() {
        return debtBalance;
    }

    public void setDebtBalance(Double debtBalance) {
        this.debtBalance = debtBalance;
    }

    public Double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(Double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "CreditCalcInfo{" +
                "creditCalcInfoId=" + creditCalcInfoId +
                ", paymentNum=" + paymentNum +
                ", monthlyPayment=" + monthlyPayment +
                ", period='" + period + '\'' +
                ", debtRepaymentPortion=" + debtRepaymentPortion +
                ", interestCharges=" + interestCharges +
                ", debtBalance=" + debtBalance +
                ", totalPaymentAmount=" + totalPaymentAmount +
                ", credit=" + credit +
                '}';
    }
}
