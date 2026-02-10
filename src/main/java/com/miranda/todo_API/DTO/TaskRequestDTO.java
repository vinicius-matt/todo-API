package com.miranda.todo_API.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TaskRequestDTO {

    @NotBlank(message = "Titulo é Obrigatório")
    private String titulo;

    private String descricao;

    private LocalDate dataVencimento;

    private LocalDate dataCriacao;

}
