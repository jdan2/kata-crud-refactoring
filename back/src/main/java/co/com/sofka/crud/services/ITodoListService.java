package co.com.sofka.crud.services;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.dto.TodoListDTO;
import co.com.sofka.crud.entitys.TodoList;

public interface ITodoListService {

    Iterable<TodoListDTO> listTodoList();

    TodoListDTO saveList(TodoListDTO todoList);


    Iterable<TodoDTO> listTodos();

    TodoDTO save(TodoDTO todo);

    void deleteTodoList(Long id);

    void deleteTodo(Long id);

}
