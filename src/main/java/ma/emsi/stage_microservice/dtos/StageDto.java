package ma.emsi.stage_microservice.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class StageDto {
    private String lieu;
    private String duree;
}
