package com.miranda.todo_API.Service;

import com.miranda.todo_API.DTO.TaskRequestDTO;
import com.miranda.todo_API.Repository.TaskRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskService {

    private final TaskRespository taskRespository;

    public TaskService(TaskRepository taskRepository){
        this.taskRespository = taskRepository;
    }

    public criarTask(TaskRequestDTO dto){

        if(dto.getDataVencimento() != null &&
        dto.getDataVencimento().isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Data de vencimento não pode ser no passado!");
        }

        Task task = new Task();
        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setDataCriacao(dto.getDataCriacao());
        task.setDataVencimento(dto.getDataVencimento());
        task.setStatus("Pendente");

        return taskRespository.save(task);
    }
}

