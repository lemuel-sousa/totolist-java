package com.limaoDev.todolist.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.limaoDev.todolist.constants.TaskStatus;
import com.limaoDev.todolist.model.Task;
import com.limaoDev.todolist.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    // Create new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // List all tasks
    public List<Task> listAllTasks() {
        return taskRepository.findAll();
    }

    // Find task by id
    public ResponseEntity<Task> findTaskById(Long id) {
        return taskRepository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    // List pendings tasks
    public List<Task> listPendingTasks() {
        return taskRepository.findByStatus(TaskStatus.PENDING);
    }

    // List completeds tasks
    public List<Task> listCompletedTasks() {
        return taskRepository.findByStatus(TaskStatus.COMPLETED);
    }

    // Toggle task status by id
    public ResponseEntity<Task> toggleTaskStatus(Task task, Long id){
        return taskRepository.findById(id)
                .map(taskToToggleStatus -> {
                    if( taskToToggleStatus.getStatus() == TaskStatus.PENDING){
                        taskToToggleStatus.setStatus(TaskStatus.COMPLETED);
                    } else if (  taskToToggleStatus.getStatus() == TaskStatus.COMPLETED){
                        taskToToggleStatus.setStatus(TaskStatus.PENDING);
                    }

                    Task statusUpdated = taskRepository.save(taskToToggleStatus);

                    return ResponseEntity.ok().body(statusUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Update task by id
    public ResponseEntity<Task> updateTaskById(Task task, Long id) {
        return taskRepository.findById(id)
                .map(taskToUpdate -> {

                    taskToUpdate.setTitle(task.getTitle());
                    taskToUpdate.setDescription(task.getDescription());
                    taskToUpdate.setDeadLine(task.getDeadLine());
                    taskToUpdate.setStatus(task.getStatus());

                    Task updated = taskRepository.save(taskToUpdate);

                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Delete task by id
    public ResponseEntity<Object> deleteTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskToDelete -> {

                    taskRepository.deleteById(id);

                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
