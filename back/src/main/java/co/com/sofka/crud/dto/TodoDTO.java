package co.com.sofka.crud.dto;

public class TodoDTO {

    private Long id;
    private String name;
    private boolean completed;
    private Long groupListId;

    public TodoDTO(Long id, String name, boolean completed, Long groupListId) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.groupListId = groupListId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long identificador) {
        this.id = identificador;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(Long groupListId) {
        this.groupListId = groupListId;
    }
}
