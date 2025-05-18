package castis.career.todo.domain.task.service;

import castis.career.todo.domain.task.dto.TaskCommonDto;
import castis.career.todo.domain.task.entity.Task;
import castis.career.todo.domain.task.repository.TaskRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

//    public TaskCommonDto createTask(TaskCommonDto taskCommonDto) {
//        Task task = taskRepository.save()
//    }

    public TaskCommonDto getTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);

        if (task.isPresent()) {
            return TaskCommonDto.builder()
                    .taskTitle(task.get().getTaskTitle())
                    .taskDescription(task.get().getTaskDescription())
                    .dateFrom(task.get().getDateFrom())
                    .dateTo(task.get().getDateTo())
                    .isDone(task.get().getIsDone())
                    .build();
        }
        return TaskCommonDto.builder().build();
    }

    public List<TaskCommonDto> getTask() {
        return null;
    }
}
