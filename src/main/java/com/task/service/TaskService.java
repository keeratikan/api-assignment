package com.task.service;

import java.util.List;

import com.task.model.Task;

public interface TaskService {
	
	Task findById(long id);
	
	void saveTask(Task task);
	
	void updateTask(Task task);
	
	void deleteTaskById(long id);

	List<Task> findAllTasks();
	
	void deleteAllTasks();
	
	boolean isTaskExist(Task task);
}
