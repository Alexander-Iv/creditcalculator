package alexander.ivanov.creditcalculator.backend.repository;

import alexander.ivanov.creditcalculator.backend.model.CreditCalcInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCalcInfoRepository extends JpaRepository<CreditCalcInfo, Long> {
}
