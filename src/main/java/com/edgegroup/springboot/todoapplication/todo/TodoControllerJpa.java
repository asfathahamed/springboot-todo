package com.edgegroup.springboot.todoapplication.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("todo-list")
	public String todoList(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Todo> listByUser = todoRepository.findByUsername(username);
		model.put("list", listByUser);
		return "listView";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addTodo(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addTodoView";
	}

	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String submitTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodoView";
		}
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todo-list";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="edit-todo", method=RequestMethod.GET)
	public String editTodo(ModelMap model, @RequestParam int id) {
		Todo todo = todoRepository.findById(id).get();
		model.put("todo", todo);
		return "editTodoView";
	}

	@RequestMapping(value="edit-todo", method=RequestMethod.POST)
	public String eTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "editTodoView";
		}
		todoRepository.save(todo);
		return "redirect:todo-list";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
