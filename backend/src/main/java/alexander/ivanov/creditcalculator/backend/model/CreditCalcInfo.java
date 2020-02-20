package alexander.ivanov.creditcalculator.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "credit_calc_info")
public class CreditCalcInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_calc_info_seq")
    @SequenceGenerator(name = "credit_calc_info_seq", sequenceName = "credit_calc_info_seq", allocationSize = 1)
    @Column(name = "credit_calc_info_id")
    private Long creditCalcInfoId;

    @Column(name = "payment_num")
    private Integer paymentNum;

    @Column(name = "monthly_payment")
    private Double monthlyPayment;

    @Column(name = "period")
    private String period;

    @Column(name = "debt_repayment_portion")
    private Double debtRepaymentPortion;

    @Column(name = "interest_charges")
    private Double interestCharges;

    @Column(name = "debt_balance")
    private Double debtBalance;

    @Column(name = "total_payment_amount")
    private Double totalPaymentAmount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "credit_credit_id"/*, referencedColumnName = "credit_id"*/)
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
