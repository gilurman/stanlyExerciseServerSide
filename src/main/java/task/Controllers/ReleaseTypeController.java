package task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.Services.ReleaseTypeService;
import task.models.ReleaseType;

import java.util.List;

@RequestMapping("/ReleaseType")
@RestController
public class ReleaseTypeController {

    @Autowired
    ReleaseTypeService Service;

    @GetMapping()
    public List<ReleaseType> getAllTypes()
    {
        return Service.getAllTypes();
    }

}
