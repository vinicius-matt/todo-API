package com.miranda.todo_API.Repository;

import com.miranda.todo_API.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository <TaskEntity, Long> {
}
