package com.limaoDev.todolist.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.limaoDev.todolist.constants.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "tasks")
@Getter
@Setter
@ToString
public class Task {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    @Column( nullable = false)
    private String title;

    @Column( nullable = true)
    private String description;

    @Column( nullable = false)
    private LocalDateTime deadLine;

    @Column( nullable = true)
    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.PENDING;
    
    @CreationTimestamp
    @Column( name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;


    @UpdateTimestamp
    @Column( name = "updated_at")
    private LocalDateTime updatedAt;


}
