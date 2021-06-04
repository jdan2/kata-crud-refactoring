package co.com.sofka.crud.services;

import co.com.sofka.crud.dto.TodoDTO;

public interface ITodoService {

    Iterable<TodoDTO> list();

    TodoDTO save(TodoDTO todo);



    void delete(Long id);
}
