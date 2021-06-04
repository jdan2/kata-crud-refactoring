package co.com.sofka.crud.entitys;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "group_list")
public class TodoList {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Todo> toDos;

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

    public Set<Todo> getToDos() {
        return toDos;
    }

    public void setToDos(Set<Todo> toDos) {
        this.toDos = toDos;
    }
}
