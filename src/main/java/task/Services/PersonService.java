package task.Services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.models.Person;
import task.repositorys.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public void save(Person person) {
        if (person.getId() == null){
            person.setId(new ObjectId().toString());
        }
        repository.save(person);
    }

    public List<Person> getAllPersons()
    {
        return repository.findAll();
    }

    public Person getPersonByPersonalNumber(int personalNumber) {
        return repository.findByPersonalNumber(personalNumber);
    }

    public void deletePerson(String id)
    {
        repository.deleteById(id);
    }
}
