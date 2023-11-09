package com.edgegroup.springboot.todoapplication.todo;

import java.time.LocalDate;
import java.util.List;

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
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("todo-list")
	public String todoList(ModelMap model) {
		List<Todo> listByUser = todoService.getListByUser();
		model.put("list", listByUser);
		return "listView";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addTodo(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addTodoView";
	}

	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String submitTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodoView";
		}
		String username = (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate());
		return "redirect:todo-list";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="edit-todo", method=RequestMethod.GET)
	public String editTodo(ModelMap model, @RequestParam int id) {
		String username = (String)model.get("name");
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "editTodoView";
	}

	@RequestMapping(value="edit-todo", method=RequestMethod.POST)
	public String eTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "editTodoView";
		}
		String username = (String)model.get("name");
		todoService.editTodo(todo);
		return "redirect:todo-list";
	}
}
