package alexander.ivanov.creditcalculator.backend.repository;

import alexander.ivanov.creditcalculator.backend.model.Credit;
import alexander.ivanov.creditcalculator.backend.model.CreditCalcInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCalcInfoRepository extends JpaRepository<CreditCalcInfo, Long> {
    List<CreditCalcInfo> findAllByCredit(Credit credit);
}
