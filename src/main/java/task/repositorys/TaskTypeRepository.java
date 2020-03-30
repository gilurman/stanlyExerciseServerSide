package task.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import task.models.TaskType;

@Repository
public interface TaskTypeRepository extends MongoRepository<TaskType, String> {
}
