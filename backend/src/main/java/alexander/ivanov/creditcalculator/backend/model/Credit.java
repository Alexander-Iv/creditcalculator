package alexander.ivanov.creditcalculator.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "credit")
public class Credit {
    @Id
    @Column(name = "credit_id")
    private Long creditId;

    @Column(name = "credit_amount")
    private Integer creditAmount;

    @Column(name = "credit_time")
    private Integer creditTime;

    @OneToOne
    @JoinColumn(name = "itrt_itrt_id", referencedColumnName = "itrt_id")
    private InterestRate interestRate;

    public Credit() {
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
}
