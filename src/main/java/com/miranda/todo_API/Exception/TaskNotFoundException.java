package com.miranda.todo_API.Exception;

public class TaskNotFoundException extends RuntimeException
{
    public TaskNotFoundException(Long id)
    {
        super("Task com id " + id + " não encontrada!");
    }
}
