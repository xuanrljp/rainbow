package com.sws.rainbow.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sws.rainbow.todo.model.Task;
import com.sws.rainbow.todo.repository.TaskRepository;
import com.sws.rainbow.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	
	private TaskRepository taskRepository;
	
	@Autowired
	public TodoServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}
	
	@Transactional(readOnly = true)
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Task findTask(Long id) {
		return taskRepository.findOne(id);
	}

	@Transactional
	public void saveTask(Task task) {
		if(taskRepository.update(task) <= 0) {
			taskRepository.insert(task);
		}
	}
	
	@Transactional
	public void removeTask(Long id) {
		taskRepository.delete(id);
	}

}
