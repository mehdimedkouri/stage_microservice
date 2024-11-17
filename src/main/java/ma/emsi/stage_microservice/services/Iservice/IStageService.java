package ma.emsi.stage_microservice.services.Iservice;

import ma.emsi.stage_microservice.controllers.StageController;
import ma.emsi.stage_microservice.dtos.StageDto;
import ma.emsi.stage_microservice.exceptions.StageAlreadyExistingException;
import ma.emsi.stage_microservice.exceptions.StageNotFoundException;
import ma.emsi.stage_microservice.models.Stage;

import java.util.List;

public interface IStageService {
    void addStage (Stage stage) throws StageNotFoundException, StageAlreadyExistingException;
    void deleteStage(Long stageId) throws StageNotFoundException;
    void updateStage(Long stageId, StageDto stage) throws StageNotFoundException;
    Stage findStageById(Long stageId) throws StageNotFoundException;
    List<Stage> getAll();
}
