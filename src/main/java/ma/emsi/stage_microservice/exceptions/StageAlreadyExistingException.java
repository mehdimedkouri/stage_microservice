package ma.emsi.stage_microservice.exceptions;

public class StageAlreadyExistingException extends Exception{
    public StageAlreadyExistingException(String message) {
        super(message);
    }
}
