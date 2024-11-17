package ma.emsi.stage_microservice.errors;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponse {
    private int statusCode;
    private String message;
}
