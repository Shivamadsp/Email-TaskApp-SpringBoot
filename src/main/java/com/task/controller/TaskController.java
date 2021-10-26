package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.TaskAssigned;
import com.task.repository.TaskRepository;
import com.task.service.TaskMailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/taskForUser")
@Api(value = "/taskForUser", tags="Task management")
public class TaskController {

	private static final Logger LOGGER=LoggerFactory.getLogger(TaskController.class);
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private TaskMailService taskMailService;
	
	
	@PostMapping("/saveTask")
	@ApiOperation(value = "Creating task for users", notes = "Crating task for users and sending notification through email", tags = {"Task assigner"})
	public void saveTask(@RequestBody TaskAssigned task) 
	{
		LOGGER.info("Calling mail service class taskMailService");
		taskMailService.sendEmail(task);
		LOGGER.info("Mail service class called");
		taskRepo.save(task);
		LOGGER.info("Data saved in h2 database successfully");
	}
	
	
	@GetMapping("/findAllTask")
	@ApiOperation(value = "Returning task assgined", notes = "Displaying all the task assigned to users with email id", tags = {"Task reciever"})
	public List<TaskAssigned> findAllTask()
	{
		LOGGER.info("Returning all the saved task with the assignee eamil id");
		return taskRepo.findAll();
	}
	
	public void schedular() {
		
	}
}
