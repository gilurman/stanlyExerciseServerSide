package task.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@AllArgsConstructor
@Data
public class Task {
    @Id
    private String id;
    private TaskType type;
    private Date startDate;
    private Date endDate;
    private Person[] persons;
}
