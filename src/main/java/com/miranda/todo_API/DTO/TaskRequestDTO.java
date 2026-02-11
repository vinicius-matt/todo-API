package com.miranda.todo_API.DTO;

import com.miranda.todo_API.model.TaskPriority;
import com.miranda.todo_API.model.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Schema(hidden = true)
public class TaskRequestDTO {

    @NotBlank(message = "Titulo é Obrigatório")
    private String titulo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    private TaskPriority priority;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private LocalDate createdAt;
}
