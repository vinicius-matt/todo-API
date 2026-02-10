package com.miranda.todo_API.Service;

import com.miranda.todo_API.DTO.TaskRequestDTO;
import com.miranda.todo_API.DTO.TaskResponseDTO;
import com.miranda.todo_API.DTO.TaskUpdateDTO;
import com.miranda.todo_API.Entity.TaskEntity;
import com.miranda.todo_API.Repository.TaskRepository;
import com.miranda.todo_API.model.TaskPriority;
import com.miranda.todo_API.model.TaskStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
        task.setPriority(TaskPriority.BAIXA);
        task.setDueDate(dto.getDataVencimento());
        task.setStatus(TaskStatus.PENDENTE);

        TaskEntity saved = taskRepository.save(task);

        return TaskResponseDTO.fromEntity(saved);
    }

    public List<TaskResponseDTO> getTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskResponseDTO::fromEntity)
                .toList();
    }

    public TaskResponseDTO updateTask(Long id, TaskUpdateDTO dto) {
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task não encontrada!"));

        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }

        if (dto.getTitle() != null) {
            task.setTitle(dto.getTitle());
        }

        if (dto.getPriority() != null) {
            task.setPriority(dto.getPriority());
        }

        if (dto.getStatus() != null) {
            task.setStatus(dto.getStatus());
        }

        TaskEntity updateTask = taskRepository.save(task);

        return TaskResponseDTO.fromEntity(updateTask);
    }
}

