package co.com.sofka.crud.entitys;


import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.entitys.Todo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "completed", target = "completed"),
            @Mapping(source = "groupListId", target = "groupListId")
    })
    TodoDTO todoToTodoDTO(Todo todo);
    Iterable<TodoDTO> toTodoDTOs( Iterable<Todo> todoList);

    @InheritInverseConfiguration
    Todo toTodo(TodoDTO todoDTO);
    Iterable<Todo> toTodos( List<TodoDTO> todoList);
}
