package alexander.ivanov.creditcalculator.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_seq")
    @SequenceGenerator(name = "credit_seq", sequenceName = "credit_seq", allocationSize = 1)
    @Column(name = "credit_id")
    private Long creditId;

    @Column(name = "credit_amount")
    private Integer creditAmount;

    @Column(name = "credit_time")
    private Integer creditTime;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "itrt_itrt_id", referencedColumnName = "itrt_id")
    private InterestRate interestRate;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CreditCalcInfo> creditCalcInfos;

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
