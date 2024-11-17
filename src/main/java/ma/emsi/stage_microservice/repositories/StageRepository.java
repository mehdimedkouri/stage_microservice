package ma.emsi.stage_microservice.repositories;

import ma.emsi.stage_microservice.models.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepository extends JpaRepository<Stage, Long> {
}
