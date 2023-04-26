package com.limaoDev.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.limaoDev.todolist.constants.TaskStatus;
import com.limaoDev.todolist.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
    @Query("SELECT t FROM Task t  WHERE t.status = :status")
    List<Task> findByStatus(@Param("status") TaskStatus status);

}