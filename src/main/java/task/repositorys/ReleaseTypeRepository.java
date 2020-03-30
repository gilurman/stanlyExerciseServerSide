package task.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import task.models.Person;
import task.models.ReleaseType;

@Repository
public interface ReleaseTypeRepository extends MongoRepository<ReleaseType, String>  { }
