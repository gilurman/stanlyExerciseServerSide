package task.Services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.models.ReleaseType;
import task.repositorys.ReleaseTypeRepository;

import java.util.List;

@Service
public class ReleaseTypeService {

    @Autowired
    ReleaseTypeRepository repository;

    public List<ReleaseType> getAllTypes() {
        return repository.findAll();
    }

    public void save(ReleaseType releaseType) {
        if (releaseType.getId() == null){
            releaseType.setId(new ObjectId().toString());
        }
        repository.save(releaseType);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
