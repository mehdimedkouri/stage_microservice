package ma.emsi.stage_microservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor@NoArgsConstructor
public class Stage {
    @Id
    private Long stageId;
    private String lieu;
    private String duree;
}
