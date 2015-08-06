package com.sws.rainbow.todo.repository.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sws.rainbow.core.repository.DataAccessException;
import com.sws.rainbow.todo.model.Task;
import com.sws.rainbow.todo.repository.TaskRepository;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
	private static List<Task> tasks = new ArrayList<Task>();
	
	static{
		tasks.add(new Task(1,"タスク１"));
		tasks.add(new Task(2,"タスク２"));
		tasks.add(new Task(3,"タスク３"));	
	}

	public Task findOne(Long pk) throws DataAccessException {
		Iterator<Task> iterator = tasks.iterator();
		while ( iterator.hasNext()) {
			Task task = iterator.next();
			if(task.getId() == pk) {
				return task;
			}
		}
		return null;
	}

	public List<Task> findAll() throws DataAccessException {
		return tasks;
	}

	public int delete(Long pk) throws DataAccessException {
		Iterator<Task> iterator = tasks.iterator();
		while ( iterator.hasNext()) {
			Task task = iterator.next();
			if(task.getId() == pk) {
				tasks.remove(task);
				return 1;
			}
		}
		return 0;
	}

	public int insert(Task entity) throws DataAccessException {
		tasks.add(entity);
		return 1;
	}

	public int update(Task entity) throws DataAccessException {
		Iterator<Task> iterator = tasks.iterator();
		while ( iterator.hasNext()) {
			Task task = iterator.next();
			if(task.getId() == entity.getId()) {
				task.setTitle(entity.getTitle());
				return 1;
			}
		}
		return 0;
	}


}
