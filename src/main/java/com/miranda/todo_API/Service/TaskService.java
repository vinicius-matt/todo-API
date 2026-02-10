package com.miranda.todo_API.Service;

import com.miranda.todo_API.DTO.TaskRequestDTO;
import com.miranda.todo_API.DTO.TaskResponseDTO;
import com.miranda.todo_API.Entity.TaskEntity;
import com.miranda.todo_API.Repository.TaskRepository;
import com.miranda.todo_API.model.TaskStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public TaskResponseDTO criarTask(TaskRequestDTO dto) {

        if (dto.getDataVencimento() != null &&
                dto.getDataVencimento().isBefore(LocalDate.now())) {

            throw new IllegalArgumentException(
                    "Data de vencimento não pode ser no passado!"
            );
        }

        TaskEntity task = new TaskEntity();
        task.setTitle(dto.getTitulo());
        task.setDescription(dto.getDescricao());
        task.setCreatedAt(LocalDate.now());
        task.setDueDate(dto.getDataVencimento());
        task.setStatus(TaskStatus.PENDENTE);

        TaskEntity saved = taskRepository.save(task);

        return TaskResponseDTO.fromEntity(saved);
    }

}
