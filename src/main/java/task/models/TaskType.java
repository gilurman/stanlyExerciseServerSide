package task.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Data
public class TaskType {
    @Id
    private String id;
    private String description;
    private int points;
    private ReleaseType[] releases;
}
