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


    @GetMapping(value = "api/todos")
    public Iterable<TodoDTO> list() {
        return service.listTodos();
    }

    @PostMapping(value = "api/todolist")
    public TodoListDTO saveTodoList(TodoListDTO todoList) {
        return service.saveList(todoList);
    }


    @GetMapping(value = "api/todolist")
    public Iterable<TodoListDTO> getTodoList() {
        return service.listTodoList();
    }

    @PostMapping(value = "api/{idList}/todo")
    public TodoDTO save(@PathVariable("idList")Long idList, @RequestBody TodoDTO todo) {
        return service.addNewToDoByListId(idList,todo);
    }

    @PutMapping(value = "api/todo")
    public TodoDTO update(@RequestBody TodoDTO todo) {
        System.out.println(todo.getName());
        if (todo.getId() != null) {
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
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
