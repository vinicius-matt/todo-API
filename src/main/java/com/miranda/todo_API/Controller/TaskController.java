package com.miranda.todo_API.Controller;

import com.miranda.todo_API.DTO.TaskRequestDTO;
import com.miranda.todo_API.DTO.TaskResponseDTO;
import com.miranda.todo_API.DTO.TaskUpdateDTO;
import com.miranda.todo_API.Service.TaskService;
import com.miranda.todo_API.model.TaskStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> addTask(@RequestBody TaskRequestDTO dto)
    {
        TaskResponseDTO novaTask = taskService.criarTask(dto);
        //TaskEntity novaTask = taskService.criarTask(dto);

        return ResponseEntity.ok(novaTask);
        //return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks()
    {
       List<TaskResponseDTO> tasks = taskService.getTasks();
       return ResponseEntity.ok(tasks);
    }

    @GetMapping("/status")
    public ResponseEntity<List<TaskResponseDTO>> getAllTaskStatus()
    {
        System.out.println("Status");
        return null;
    }


    @PatchMapping("/{id}")
        public ResponseEntity<TaskResponseDTO> updateTask(
                @PathVariable Long id,
                @RequestBody TaskUpdateDTO dto){

            TaskResponseDTO taskAtualizada = taskService.updateTask(id, dto);

            return ResponseEntity.ok(taskAtualizada);
        }

     @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){

        //TaskResponseDTO deletaTask = taskService.deleteTask(id);

         String msg = taskService.deleteTask(id);

        return ResponseEntity.ok(msg);
     }
}
