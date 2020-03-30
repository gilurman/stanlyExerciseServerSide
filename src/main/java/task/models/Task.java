package task.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Task {
    @Id
    private String id;
    private TaskType type;
    private Date startDate;
    private Date endDate;
    private Person[] persons;
}
