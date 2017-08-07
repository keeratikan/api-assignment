package com.task.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.task.model.Task;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	
	private static final AtomicLong counter = new AtomicLong();
	private static List<Task> tasks;
	
	static{
		tasks= populateDummyTasks();
	}

	public Task findById(long id) {
		for(Task task : tasks){
			if(task.getId() == id){
				return task;
			}
		}
		return null;
	}
	
	public Task findBySubject(String subject) {
		for(Task task : tasks){
			if(task.getSubject().equalsIgnoreCase(subject)){
				return task;
			}
		}
		return null;
	}

	public void saveTask(Task task) {
		task.setId(counter.incrementAndGet());
		tasks.add(task);
	}

	public void updateTask(Task task) {
		int index = tasks.indexOf(task);
		tasks.set(index, task);
	}

	public void deleteTaskById(long id) {
		for (Iterator<Task> iterator = tasks.iterator(); iterator.hasNext(); ) {
		    Task task = iterator.next();
		    if (task.getId() == id) {
		        iterator.remove();
		    }
		}
		
	}

	public List<Task> findAllTasks() {
		return tasks;
	}

	public void deleteAllTasks() {
		tasks.clear();
	}

	public boolean isTaskExist(Task task) {
		return findBySubject(task.getSubject())!=null;
	}
	
	private static List<Task> populateDummyTasks() {
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task(counter.incrementAndGet(),"Task One","Detail of Task One", "Pending"));
		tasks.add(new Task(counter.incrementAndGet(),"Task Two","Detail of Task Two", "Done"));
		tasks.add(new Task(counter.incrementAndGet(),"Task Three","Detail of Task Three", "Done"));
		tasks.add(new Task(counter.incrementAndGet(),"Task Four","Detail of Task Four", "Pending"));
		return tasks;
	}

}
