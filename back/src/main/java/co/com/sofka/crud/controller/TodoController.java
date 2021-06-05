package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.*;
import co.com.sofka.crud.services.TodoListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {


    @Autowired
    private TodoListServiceImpl service;

    @PostMapping(value = "api/todolist")
    public TodoListDTO saveTodoList( @RequestBody TodoListDTO todoList) {
        return service.saveList(todoList);
    }

    @PostMapping(value = "api/todo")
    public TodoDTO saveTodo(@RequestBody TodoDTO todo) {
        if (todo.getName() != null) {
            return service.save(todo);
        }
        throw new RuntimeException("No existe nombre de la tarea para guardar");
    }

    @PostMapping(value = "api/{idList}/todo")
    public TodoDTO saveById(@PathVariable("idList")Long idList, @RequestBody TodoDTO todo) {
        return service.addNewToDoByListId(idList,todo);
    }

    @GetMapping(value = "api/todos")
    public Iterable<TodoDTO> list() {
        return service.listTodos();
    }

    @GetMapping(value = "api/todolist")
    public Iterable<TodoListDTO> getTodoList() {
        return service.listTodoList();
    }


    @PutMapping(value = "api/todo")
    public TodoDTO update(@RequestBody TodoDTO todo) {
        System.out.println(todo.getName());
        if (todo.getId() != null) {
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id") Long id) {
        service.deleteTodo(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoDTO get(@PathVariable("id") Long id) {
        return service.get(id);
    }



}