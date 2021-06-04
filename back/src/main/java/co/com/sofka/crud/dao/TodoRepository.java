package co.com.sofka.crud.dao;

import co.com.sofka.crud.entitys.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
