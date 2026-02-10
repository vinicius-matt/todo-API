package com.miranda.todo_API.DTO;

import com.miranda.todo_API.model.TaskPriority;
import com.miranda.todo_API.model.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskUpdateDTO {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDate dueDate;
    private LocalDate createdAt;
}
