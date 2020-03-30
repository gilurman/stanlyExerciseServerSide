package task.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import task.models.Task;
import task.models.TaskType;
import task.repositorys.TaskRepository;
import task.repositorys.TaskTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskTypeRepository taskTypeRepository;

    public void saveNewTask(Task task) {
        taskRepository.save(task);
    }

    public void saveNewTaskType(TaskType taskType) {
        taskTypeRepository.save(taskType);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<TaskType> getAllTaskTypes() {
        return taskTypeRepository.findAll();
    }

    public Optional<Task> getTaskById(String taskId) {
        return taskRepository.findById(taskId);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    public void deleteTaskType(TaskType taskType) {
        taskTypeRepository.delete(taskType);
    }
}
