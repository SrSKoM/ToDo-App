package com.skom.todoapp.persistence.repository;

import com.skom.todoapp.persistence.entity.Task;
import com.skom.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=1:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}

