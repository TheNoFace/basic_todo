package castis.career.todo.domain.task.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskCommonDto {

    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    private String taskTitle;
    private String taskDescription;

    private Boolean isDone;
}
