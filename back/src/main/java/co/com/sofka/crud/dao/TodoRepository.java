package co.com.sofka.crud.dao;

import co.com.sofka.crud.dto.TodoDTO;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoDTO, Long> {
}
