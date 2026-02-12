package com.miranda.todo_API.Repository;

import com.miranda.todo_API.Entity.TaskEntity;
import com.miranda.todo_API.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <TaskEntity, Long> {

    List<TaskEntity>findByStatus(TaskStatus status);
}
