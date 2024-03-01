package com.in28minutes.springboot.myfirstwebapp.todo;

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

//@Controller
@SessionAttributes("name")
public class ToDoController {
	
	private ToDoService toDoService;
	
	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}

	// list-todos
	@RequestMapping("list-todos")
	public String listAllToDos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<ToDo> toDos = toDoService.findByUsername(username);
		
		model.addAttribute("toDos", toDos);
		return "listToDos";
	}
	
	// Remember to handle post or get explicitly
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		ToDo toDo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("toDo", toDo); // Note that we are binding this new "blank" ToDo to the form 
		return "toDo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewToDo(ModelMap model, @Valid ToDo toDo, BindingResult result) {
		if(result.hasErrors()) {
			return "toDo";
		}
		String username = getLoggedInUsername(model);
		toDoService.addTodo(username, toDo.getDescription(), toDo.getTargetDate(), false);//binding form to ToDo
		return "redirect:list-todos";
	}
	
	// delete-todo
	@RequestMapping("delete-todo")
	public String deleteToDo(@RequestParam int id) {
		// Delete toDo
		toDoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	// delete-todo
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateToDoPage(@RequestParam int id, ModelMap model) {
		// Update toDo
		String username = getLoggedInUsername(model);
		ToDo toDo = toDoService.findById(id);
		model.addAttribute("toDo",toDo); // Note that we are binding this new "blank" ToDo to the form 
		return "toDo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateToDo(ModelMap model, @Valid ToDo toDo, BindingResult result) {
		if(result.hasErrors()) {
			return "toDo";
		}
		String username = getLoggedInUsername(model);
		toDo.setUsername(username);
		toDoService.updateTodo(toDo);//binding form to ToDo
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
