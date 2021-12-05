package com.sec.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.security.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
