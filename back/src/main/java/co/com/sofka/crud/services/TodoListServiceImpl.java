package co.com.sofka.crud.services;

import co.com.sofka.crud.dao.TodoListRepository;
import co.com.sofka.crud.dao.TodoRepository;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.dto.TodoListDTO;
import co.com.sofka.crud.dto.TodoListMapper;
import co.com.sofka.crud.dto.TodoMapper;
import co.com.sofka.crud.entitys.Todo;
import co.com.sofka.crud.entitys.TodoList;
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


}
