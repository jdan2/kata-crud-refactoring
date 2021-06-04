package co.com.sofka.crud.dto;

import co.com.sofka.crud.entitys.Todo;

import java.util.Set;

public class TodoListDTO {

    private Long id;
    private String name;
    private Set<TodoDTO> toDos;

    public TodoListDTO(Long id, String name, Set<TodoDTO> toDos) {
        this.id = id;
        this.name = name;
        this.toDos = toDos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TodoDTO> getToDos() {
        return toDos;
    }

    public void setToDos(Set<TodoDTO> toDos) {
        this.toDos = toDos;
    }
}
