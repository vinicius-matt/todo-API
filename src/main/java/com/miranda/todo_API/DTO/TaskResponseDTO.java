package com.miranda.todo_API.DTO;

import com.miranda.todo_API.Entity.TaskEntity;
import com.miranda.todo_API.model.TaskPriority;
import com.miranda.todo_API.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDate dueDate;
    private LocalDate createdAt;

    public static TaskResponseDTO fromEntity(TaskEntity entity) {

        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setDueDate(entity.getDueDate());
        dto.setPriority(entity.getPriority());
        dto.setCreatedAt(entity.getCreatedAt());

        return dto;
    }
}
