package co.com.sofka.crud.services;

import co.com.sofka.crud.dao.TodoListRepository;
import co.com.sofka.crud.dao.TodoRepository;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.dto.TodoListDTO;
import co.com.sofka.crud.entitys.Todo;
import co.com.sofka.crud.entitys.TodoList;
import co.com.sofka.crud.entitys.TodoListMapper;
import co.com.sofka.crud.entitys.TodoMapper;
import co.com.sofka.crud.exception.customExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class TodoListServiceImpl implements ITodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private TodoListMapper todoListMapper;

    @Autowired
    private TodoRepository repository;

    @Autowired
    private TodoMapper todoMapper;


    public TodoListDTO getTodoList(Long id) {
        return todoListMapper.todoToTodoDTO(todoListRepository.findById(id).orElseThrow());
    }

    @Override
    public Iterable<TodoListDTO> listTodoList() {

        return StreamSupport
                .stream(todoListRepository.findAll().spliterator(), false)
                .map(toDoList -> {
                    var listDto = toDoList.getToDos()
                            .stream()
                            .map(item -> new TodoDTO(item.getId(), item.getName(), item.isCompleted(), toDoList.getId()))
                            .collect(Collectors.toSet());
                    return new TodoListDTO(toDoList.getId(), toDoList.getName(), listDto);
                })
                .collect(Collectors.toSet());
    }

    public TodoDTO addNewToDoByListId(Long id, TodoDTO todo) {

        var listToDo = todoListRepository.findById(id).orElseThrow();
        if(todo.getName().isEmpty()){
            throw new customExceptions("To-Do name cant be empty");
        }
        Todo todoEn = todoMapper.toTodo(todo);
        //addition new to-do
        listToDo.getToDos().add(todoEn);
        var listUpdated = todoListRepository.save(listToDo);
        //last item
        Todo lastToDo = getLastToDo(listUpdated);
        todo.setId(lastToDo.getId());
        todo.setGroupListId(id);
        return todo;
    }

    @Override
    public TodoListDTO saveList(TodoListDTO todoList) {
        return todoListMapper.todoToTodoDTO(todoListRepository.save(todoListMapper.toTodo(todoList)));
    }

    @Override
    public void deleteTodoList(Long id) {
        todoListRepository.delete(todoListMapper.toTodo(getTodoList(id)));
    }

    public TodoDTO get(Long id) {
        return todoMapper.todoToTodoDTO(repository.findById(id).orElseThrow());
    }

    @Override
    public Iterable<TodoDTO> listTodos() {
        return todoMapper.toTodoDTOs(repository.findAll());
    }

    @Override
    public TodoDTO save(TodoDTO todo) {
        return todoMapper.todoToTodoDTO(repository.save(todoMapper.toTodo(todo)));
    }

    @Override
    public void deleteTodo(Long id) {
        repository.delete(todoMapper.toTodo(get(id)));
    }

    private Todo getLastToDo(TodoList listUpdated) {
        var lastToDo = listUpdated.getToDos()
                .stream()
                .max(Comparator.comparingInt(item -> item.getId().intValue()))
                .orElseThrow();
        System.out.println(lastToDo);
        return lastToDo;
    }



}
