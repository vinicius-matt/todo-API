package com.miranda.todo_API.Controller;

import com.miranda.todo_API.DTO.TaskRequestDTO;
import com.miranda.todo_API.DTO.TaskResponseDTO;
import com.miranda.todo_API.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Task")
public class TaskController {

    private final TaskService taskService;

    public TaskController( TaskService taskService ) {
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
}
