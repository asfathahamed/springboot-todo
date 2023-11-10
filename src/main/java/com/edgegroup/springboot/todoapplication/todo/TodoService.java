package com.edgegroup.springboot.todoapplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> listOfTodos = new ArrayList();
	private static int id = 0;
	static {
		listOfTodos.add(new Todo(++id, "asfath", "Learn AWS", LocalDate.now().plusYears(1), false));
		listOfTodos.add(new Todo(++id, "asfath", "Learn Python", LocalDate.now().plusYears(1), false));
		listOfTodos.add(new Todo(++id, "asfath", "Learn Angular", LocalDate.now().plusYears(1), false));
		listOfTodos.add(new Todo(++id, "asfath", "Learn ML", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> getListByUser(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return listOfTodos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate dueDate) {
		listOfTodos.add(new Todo(++id, username, description, dueDate, false));
	}

	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		listOfTodos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return listOfTodos.stream().filter(predicate).findFirst().get();
	}
	
	public void editTodo(Todo todo) {
		deleteTodo(todo.getId());
		listOfTodos.add(todo);
	}
	
}
