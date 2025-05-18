package castis.career.todo.domain.task.controller;

import castis.career.todo.domain.task.dto.TaskCommonDto;
import castis.career.todo.domain.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/")

    @GetMapping
    public TaskCommonDto getSingleTask(@RequestParam long taskId) {
        return taskService.getTask(taskId);
    }
}
