package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.TaskAssigned;

public interface TaskRepository extends JpaRepository<TaskAssigned, Integer>{

}
