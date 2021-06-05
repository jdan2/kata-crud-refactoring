package co.com.sofka.crud.services;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.dto.TodoMapper;
import co.com.sofka.crud.entitys.Todo;
import co.com.sofka.crud.dao.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private TodoRepository repository;
    @Autowired
    private TodoMapper todoMapper;

    public TodoDTO get(Long id) {
        return todoMapper.todoToTodoDTO(repository.findById(id).orElseThrow());
    }
    @Override
    public Iterable<TodoDTO> list() {
        return todoMapper.toTodoDTOs(repository.findAll());
    }

    @Override
    public TodoDTO save(TodoDTO todo) {
        return todoMapper.todoToTodoDTO(repository.save(todoMapper.toTodo(todo)));
    }

    @Override
    public void delete(Long id) {
        repository.delete(todoMapper.toTodo(get(id)));
    }
}
