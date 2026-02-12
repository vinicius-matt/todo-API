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

        if (dto.getDueDate() != null &&
                dto.getDueDate().isBefore(LocalDate.now())) {

            throw new IllegalArgumentException(
                    "Data de vencimento não pode ser no passado!"
            );
        }

        TaskEntity task = new TaskEntity();
        task.setTitle(dto.getTitulo());
        task.setDescription(dto.getDescription());
        task.setCreatedAt(LocalDate.now());
        task.setDueDate(dto.getDueDate());

        task.setPriority(TaskPriority.None);
        task.setStatus(TaskStatus.None);

        TaskEntity saved = taskRepository.save(task);

        return TaskResponseDTO.fromEntity(saved);
    }

    public List<TaskResponseDTO> getTasks() {

        UpdateOverdueTasks();

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

    public String deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task não encontrada");
        }
        taskRepository.deleteById(id);
        return "Task deletada com sucesso!";
    }

    public void UpdateOverdueTasks(){

        List<TaskEntity> tasks = taskRepository.findAll();

        for (TaskEntity task : tasks) {

            if (task.getDueDate()  != null && task.getDueDate().isBefore(LocalDate.now()) &&
            task.getStatus() != TaskStatus.CONCLUIDA) {

                task.setStatus(TaskStatus.VENCIDA);
                taskRepository.save(task);
            }
        }

    }
}

