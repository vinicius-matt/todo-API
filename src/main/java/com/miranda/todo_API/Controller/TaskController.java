package com.miranda.todo_API.Controller;

import com.miranda.todo_API.DTO.TaskRequestDTO;
import com.miranda.todo_API.DTO.TaskResponseDTO;
import com.miranda.todo_API.DTO.TaskUpdateDTO;
import com.miranda.todo_API.Repository.TaskRepository;
import com.miranda.todo_API.Service.TaskService;
import com.miranda.todo_API.model.TaskStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Task")
public class TaskController {

    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @PostMapping("/criarTask")
    public ResponseEntity<TaskResponseDTO> addTask(@RequestBody TaskRequestDTO dto) {
        TaskResponseDTO novaTask = taskService.criarTask(dto);
        System.out.println("Prioridade recebida: " + dto.getPriority());

        return ResponseEntity.ok(novaTask);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskResponseDTO> tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/status")
    public ResponseEntity<List<TaskResponseDTO>> getAllStatus(
            @PathVariable TaskStatus status
    ) {
        List<TaskResponseDTO> task = taskService.getTaskByStatus(status);
        return ResponseEntity.ok(task);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(
            @PathVariable Long id,
            @RequestBody TaskUpdateDTO dto) {

        TaskResponseDTO taskAtualizada = taskService.updateTask(id, dto);

        return ResponseEntity.ok(taskAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }


}
