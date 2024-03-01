package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	private static List<ToDo> toDos = new ArrayList<ToDo>();
	private static int toDosCount = 0;
	
	static {
		toDos.add(new ToDo(++toDosCount, "in28minutes", "Learn AWS", LocalDate.now().plusYears(1), false));
		toDos.add(new ToDo(++toDosCount, "in28minutes", "Learn DevOps", LocalDate.now().plusMonths(6), false));
		toDos.add(new ToDo(++toDosCount, "in28minutes", "Learn FullStack Development", LocalDate.now().plusWeeks(8), false));
		toDos.add(new ToDo(++toDosCount, "in28minutes", "Learn SpringBoot", LocalDate.now().plusWeeks(2), false));
	}
	
	public List<ToDo> findByUsername(String username){
		Predicate<? super ToDo> predicate = toDo -> toDo.getUsername().equalsIgnoreCase(username);
		return toDos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++toDosCount, username, description, targetDate, done);
		toDos.add(todo);
	}
	
	public void deleteById(int id) {
		// toDo.getId() == id;
		// toDo -> toDo.getId() == id;
		Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
		toDos.removeIf(predicate);
	}

	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
		ToDo toDo = toDos.stream().filter(predicate).findFirst().get();
		return toDo;
	}

	public void updateTodo(@Valid ToDo toDo) {
		deleteById(toDo.getId());
		toDos.add(toDo);		
	}
}
