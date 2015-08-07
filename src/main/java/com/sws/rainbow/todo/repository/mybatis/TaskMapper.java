package com.sws.rainbow.todo.repository.mybatis;

import java.util.List;

import com.sws.rainbow.todo.model.Task;

public interface TaskMapper {

    Task selectByPrimaryKey(Integer id);
    
    List<Task> selectAll();
    
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Task task);

    Integer update(Task task);

}