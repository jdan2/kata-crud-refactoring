package co.com.sofka.crud.entitys;

import co.com.sofka.crud.dto.TodoListDTO;
import co.com.sofka.crud.entitys.Todo;
import co.com.sofka.crud.entitys.TodoList;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TodoListMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "toDos", target = "toDos")
    })
    TodoListDTO todoToTodoDTO(TodoList todo);
    Iterable<TodoListDTO> toTodoDTOs( Iterable<TodoList> todoList);

    @InheritInverseConfiguration
    TodoList toTodo(TodoListDTO todoDTO);
    Iterable<TodoList> toTodos( Iterable<TodoListDTO> todoList);
}
