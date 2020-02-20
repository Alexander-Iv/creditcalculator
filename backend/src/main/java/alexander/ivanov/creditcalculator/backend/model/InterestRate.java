package alexander.ivanov.creditcalculator.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "interest_rate")
public class InterestRate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interest_rate_seq")
    @SequenceGenerator(name = "interest_rate_seq", sequenceName = "interest_rate_seq", allocationSize = 1)
    @Column(name = "itrt_id")
    private Long interestRateId;

    @Column(name = "itrt_rate")
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
