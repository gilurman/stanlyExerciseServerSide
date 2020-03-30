package task.models;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class TaskType {
    @Id
    private String id;
    private String description;
    private int points;
    private ReleaseType[] releases;
}
