package task.Controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.Services.ReleaseTypeService;
import task.models.Person;
import task.models.ReleaseType;

import java.util.List;

@RequestMapping("/ReleaseType")
@RestController
public class ReleaseTypeController {

    @Autowired
    ReleaseTypeService service;

    @GetMapping()
    public List<ReleaseType> getAllTypes()
    {
        return service.getAllTypes();
    }

    @PostMapping
    public void save(@RequestBody ReleaseType releaseType)
    {
        service.save(releaseType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
