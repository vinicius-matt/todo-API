package com.miranda.todo_API.DTO;

import com.miranda.todo_API.Entity.TaskEntity;
import com.miranda.todo_API.model.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(hidden = true)
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;
    private LocalDate createdAt;

    public static TaskResponseDTO fromEntity(TaskEntity entity) {

        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setDueDate(entity.getDueDate());
        dto.setCreatedAt(entity.getCreatedAt());

        return dto;
    }
}
