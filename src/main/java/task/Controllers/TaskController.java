package task.Controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import task.Services.TaskService;
import task.models.ReleaseType;
import task.models.Task;
import task.models.TaskType;

import java.util.List;


@RestController
public class TaskController {

    @Autowired
    TaskService service;

    @PostMapping("/task")
    public void saveNewTask(@RequestBody Task task) {
        service.saveNewTask(task);
    }

    @PostMapping("/taskType")
    public void saveNewTaskType(@RequestBody TaskType taskType) {
        service.saveNewTaskType(taskType);
    }

    @GetMapping("/task")
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/taskType")
    public List<TaskType> getAllTaskTypes() {
        return service.getAllTaskTypes();
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable String id) {
        service.deleteTask(id);
    }

    @DeleteMapping("/taskType/{id}")
    public void deleteTaskType(@PathVariable String id) {
        service.deleteTaskType(id);
    }
}
