package com.task.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.task.model.Task;
import com.task.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskRestApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(TaskRestApiController.class);
	@Autowired
	TaskService taskService;
	
	//View all items in the list
	@RequestMapping(value = "/task/", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> listAllTasks() {
		logger.info("View all item");
		List<Task> tasks = taskService.findAllTasks();
		if (tasks.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}
	
	//View a single task in the list
	@RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTask(@PathVariable("id") long id){
		logger.info("View a single task with id {}", id);
		Task task = taskService.findById(id);
		if (task == null) {
			logger.error("Task id {} not found.", id);
			return new ResponseEntity("Task with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	//Add a task to the list
	@RequestMapping(value = "/task/", method = RequestMethod.POST)
	public ResponseEntity<?> addTask(@RequestBody Task task, UriComponentsBuilder ucBuilder) {
		logger.info("Add a Task : {}", task);

		if (taskService.isTaskExist(task)) {
			logger.error("Unable to add. A task with subject{} already exist.", task.getSubject());
			return new ResponseEntity("Unable to add. A task with subject " + task.getSubject() + " already exist.",HttpStatus.CONFLICT);
		}
		taskService.saveTask(task);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/task/{id}").buildAndExpand(task.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	//Edit existing task
	@RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> editTask(@PathVariable("id") long id, @RequestBody Task task) {
		logger.info("Edit task with id {}", id);

		Task currentTask = taskService.findById(id);

		if (currentTask == null) {
			logger.error("Unable to update. Task with id {} not found.", id);
			return new ResponseEntity("Unable to upate. Task with id " + id + " not found.",HttpStatus.NOT_FOUND);
		}

		currentTask.setSubject(task.getSubject());
		currentTask.setDetail(task.getDetail());
		currentTask.setStatus(task.getStatus());

		taskService.updateTask(currentTask);
		return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
	}
	
	//Delete a task from the list
	@RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTask(@PathVariable("id") long id) {
		logger.info("Delete a Task with id {}", id);

		Task task = taskService.findById(id);
		if (task == null) {
			logger.error("Unable to delete. Task with id {} not found.", id);
			return new ResponseEntity("Unable to delete. Task with id " + id + " not found.",HttpStatus.NOT_FOUND);
		}
		taskService.deleteTaskById(id);
		return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
	}
	
	//Set the task status
	@RequestMapping(value = "/task/status/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> setTaskStatus(@PathVariable("id") long id, @RequestBody Task task) {
		logger.info("Set task status with id {}", id);

		Task currentTask = taskService.findById(id);

		if (currentTask == null) {
			logger.error("Unable to update. Task with id {} not found.", id);
			return new ResponseEntity("Unable to update. Task with id " + id + " not found.",HttpStatus.NOT_FOUND);
		}

		currentTask.setStatus(task.getStatus());

		taskService.updateTask(currentTask);
		return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
	}

}
