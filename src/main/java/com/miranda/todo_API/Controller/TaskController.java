package com.miranda.todo_API.Controller;

import com.miranda.todo_API.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
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
    public ResponseEntity<Task> addTask(@RequestBody Task task ) {
        Task task = taskService.criarTask(dto);

        return ResponseEntity.ok(task);
        //return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
