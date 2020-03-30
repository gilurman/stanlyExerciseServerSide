package task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import task.Services.TaskService;
import task.models.Task;
import task.models.TaskType;

import java.util.List;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    TaskService service;

    public void saveNewTask(@RequestBody Task task) {
        service.saveNewTask(task);
    }

    public void saveNewTaskType(@RequestBody TaskType taskType) {
        service.saveNewTaskType(taskType);
    }

    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    public List<TaskType> getAllTaskTypes() {
        return service.getAllTaskTypes();
    }

    public Task getTaskById(String taskId) {
        return service.getTaskById(taskId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteTask(Task task) {
        service.deleteTask(task);
    }

    public void deleteTaskType(TaskType taskType) {
        service.deleteTaskType(taskType);
    }
}
