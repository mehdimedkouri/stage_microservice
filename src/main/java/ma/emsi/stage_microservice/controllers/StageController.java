package ma.emsi.stage_microservice.controllers;

import ma.emsi.stage_microservice.dtos.StageDto;
import ma.emsi.stage_microservice.errors.ErrorResponse;
import ma.emsi.stage_microservice.exceptions.StageAlreadyExistingException;
import ma.emsi.stage_microservice.exceptions.StageNotFoundException;
import ma.emsi.stage_microservice.models.Stage;
import ma.emsi.stage_microservice.services.Iservice.IStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/stage")
public class StageController {
    private final IStageService stageService;
    @Autowired
    public StageController(IStageService iStageService) {
        this.stageService = iStageService;
    }
    @PostMapping(path = "/add-stage")
    public ResponseEntity<?> addStage(@RequestBody Stage stage) throws StageAlreadyExistingException, StageNotFoundException {
        this.stageService.addStage(stage);
        return ResponseEntity.ok(stage);
    }

    @PutMapping(path ="/update/{stageId}")
    public ResponseEntity<?> updateStage(@PathVariable long stageId, @RequestBody StageDto stage)
    throws StageNotFoundException {
        this.stageService.updateStage(stageId, stage);
        return ResponseEntity.ok(stage);
    }

    @DeleteMapping(path = "/delete/{stageId}")
    public ResponseEntity<Void> deleteStage(@PathVariable long stageId)
        throws StageNotFoundException{
        this.stageService.deleteStage(stageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{stageId}")
    public ResponseEntity<Stage> findStageById(@PathVariable long stageId)
        throws StageNotFoundException{
        Stage stage = this.stageService.findStageById(stageId);
        return ResponseEntity.ok(stage);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Stage>> getAll(){
        List<Stage> all = this.stageService.getAll();
        return ResponseEntity.ok(all);
    }

}
