package com.miranda.todo_API.Entity;

import com.miranda.todo_API.model.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class taskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    private LocalDate dataVencimento;

    private LocalDate dataCriacao;

    public taskEntity() {}
}

