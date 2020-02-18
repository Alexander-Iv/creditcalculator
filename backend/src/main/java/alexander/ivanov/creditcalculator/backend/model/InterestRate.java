package alexander.ivanov.creditcalculator.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "interest_rate")
public class InterestRate {
    @Id
    @Column(name = "itrt_id")
    private Long interestRateId;

    @Column(name = "itrt_rate")
    private Double interestRate;

    public InterestRate() {
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
}
