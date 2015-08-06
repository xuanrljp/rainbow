package com.sws.rainbow.todo.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sws.rainbow.todo.model.Task;
import com.sws.rainbow.todo.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoAction {
	private final TodoService todoService;

	@Autowired
	public TodoAction(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String initNew(Model model) {
		Task task = new Task();
		model.addAttribute("task",task);
		return "todo/edit";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveNew(@ModelAttribute Task task, BindingResult result) {
		todoService.saveTask(task);
		return "redirect:/todo/" + task.getId() + "/edit";
	}	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Task> tasks = todoService.getTasks();
		model.addAttribute("tasks",tasks);
		return "todo/list";
	}	

	@RequestMapping(value = "/{taskId}/edit", method = RequestMethod.GET)
	public String initEdit(@PathVariable("taskId") long taskId,Model model) {
		Task task = todoService.findTask(taskId);
		model.addAttribute("task",task);
		return "todo/edit";
	}
	
	@RequestMapping(value = "/{taskId}/edit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute Task task, BindingResult result) {
		todoService.saveTask(task);
		return "redirect:/todo/" + task.getId() + "/edit";
	}
	
	@RequestMapping(value = "/{taskId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("taskId") long taskId,Model model) {
		todoService.removeTask(taskId);
		return "redirect:/todo/list";
	}	
}
