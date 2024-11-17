package ma.emsi.stage_microservice.services.IserviceImp;

import ma.emsi.stage_microservice.dtos.StageDto;
import ma.emsi.stage_microservice.exceptions.StageAlreadyExistingException;
import ma.emsi.stage_microservice.exceptions.StageNotFoundException;
import ma.emsi.stage_microservice.models.Stage;
import ma.emsi.stage_microservice.repositories.StageRepository;
import ma.emsi.stage_microservice.services.Iservice.IStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IStageServiceImpl implements IStageService {
    private final StageRepository stageRepository;
    @Autowired
    public IStageServiceImpl(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    @Override
    public void addStage(Stage stage) throws StageAlreadyExistingException {
        Stage findById = null;
        try {
            findById = this.findStageById(stage.getStageId());
        }catch (StageNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        if(findById != null){
            throw new StageAlreadyExistingException("Stage Already Exist!");
        }
        this.stageRepository.save(stage);
    }

    @Override
    public void deleteStage(Long stageId) throws StageNotFoundException {
        Stage stageById = this.findStageById(stageId);
        this.stageRepository.delete(stageById);
    }

    @Override
    public void updateStage(Long stageId, StageDto stage) throws StageNotFoundException{
        Stage stageById = this.findStageById(stageId);
        stageById.setLieu(stage.getLieu());
        stageById.setDuree(stage.getDuree());
        this.stageRepository.save(stageById);

    }

    @Override
    public Stage findStageById(Long stageId) throws StageNotFoundException {
        Optional<Stage> optionalStage = this.stageRepository.findById(stageId);
        if(optionalStage.isEmpty()){
            throw new StageNotFoundException("Stage not found Exception!");
        }
        return optionalStage.get();
    }

    @Override
    public List<Stage> getAll() {
        return this.stageRepository.findAll();
    }
}
