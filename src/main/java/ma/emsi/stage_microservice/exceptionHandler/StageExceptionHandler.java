package ma.emsi.stage_microservice.exceptionHandler;

import ma.emsi.stage_microservice.controllers.StageController;
import ma.emsi.stage_microservice.errors.ErrorResponse;
import ma.emsi.stage_microservice.exceptions.StageAlreadyExistingException;
import ma.emsi.stage_microservice.exceptions.StageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = StageController.class)
public class StageExceptionHandler {

    @ExceptionHandler(value = StageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handlingStageNotFoundException(StageNotFoundException ex){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = StageAlreadyExistingException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse handlingStageAlreadyExistingException(StageAlreadyExistingException ex){
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }

    }
