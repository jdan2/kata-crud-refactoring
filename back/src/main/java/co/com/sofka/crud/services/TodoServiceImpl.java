package co.com.sofka.crud.services;

import co.com.sofka.crud.dto.TodoDTO;

import co.com.sofka.crud.dao.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private TodoRepository repository;


    @Override
    public Iterable<TodoDTO> list() {
        return null;
    }

    @Override
    public TodoDTO save(TodoDTO todo) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
}
