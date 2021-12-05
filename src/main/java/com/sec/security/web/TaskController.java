package com.sec.security.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sec.security.dao.TaskRepository;
import com.sec.security.entities.Task;

@RestController
public class TaskController {
@Autowired
private TaskRepository taskRepository;
@GetMapping("tasks")
public List<Task> getTaskList()
{
	
return taskRepository.findAll();

}
@PostMapping("tasks")
public Task addTask(@Valid @RequestBody Task task)
{
	return taskRepository.save(task);

}
}
