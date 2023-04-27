package com.limaoDev.todolist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.limaoDev.todolist.model.Task;
import com.limaoDev.todolist.service.TaskService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class TaskController {

    private TaskService taskService;

    //Create new task
    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody() Task task) {
        log.info("New task created with informations [{}]", task);
        return taskService.createTask(task);
    }

    //Get all tasks
    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        log.info("Listing all registered tasks");
        return taskService.listAllTasks();
    }

    //Get tasks by id
    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long id) {
        log.info("Searching task with id [{}]", id);
        return taskService.findTaskById(id);
    }

    //Get pending tasks
    @GetMapping("/tasks/pending")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getPendingTasks(){
        return taskService.listPendingTasks();
    }

    //Get completed tasks
    @GetMapping("/tasks/completed")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getCompletedTasks(){
        return taskService.listCompletedTasks();
    }

    //Toggle status
    @PutMapping("/tasks/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> toggleTaskStatus(@PathVariable( value = "id") Long id, Task task){
        return taskService.toggleTaskStatus(task, id);
    }


    //Update task
    @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable(value = "id") Long id, @RequestBody Task task) {
        log.info("Updating task information with id '{}': [{}]", id, task);
        return taskService.updateTaskById(task, id);
    }

    //Delete task
    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> delteTaskById(@PathVariable(value = "id") Long id) {
        log.info("Task with id '{}' deleted", id);
        return taskService.deleteTaskById(id);
    }
}