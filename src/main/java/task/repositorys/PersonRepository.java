package task.repositorys;
import java.util.List;

import org.springframework.stereotype.Repository;
import task.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByLastName(String name);
    Person findByPersonalNumber(int personalNumber);
}

