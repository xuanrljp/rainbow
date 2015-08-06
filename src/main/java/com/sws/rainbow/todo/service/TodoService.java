package com.sws.rainbow.todo.service;

import java.util.List;

import com.sws.rainbow.todo.model.Task;

public interface TodoService {
	List<Task> getTasks();
	
	Task findTask(Long id);
	
	void saveTask(Task task);
	
	void removeTask(Long id);	
}
