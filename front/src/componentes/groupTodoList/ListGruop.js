import React, { useContext,  useEffect } from "react";
import Store from "../../Store";

const HOST_API = "http://localhost:8080/api";
const List = () => {
    const { dispatch, state: { todoList } } = useContext(Store);
    const currentList = todoList.list;
  
    useEffect(() => {
      fetch(HOST_API + "/todos")
        .then(response => response.json())
        .then((list) => {
          dispatch({ type: "update-list", list })
        })
    }, [dispatch]);
  
  
    const onDelete = (id) => {
      fetch(HOST_API + "/" + id + "/todo", {
        method: "DELETE"
      }).then((list) => {
        dispatch({ type: "delete-item", id })
      })
    };
  
    const onEdit = (todoList) => {
      dispatch({ type: "edit-item", item: todoList })
    };
  
    const onChange = (event, todoList) => {
      const request = {
        name: todoList.name,
        id: todoList.id,
        completed: event.target.checked
      };
      fetch(HOST_API + "/todo", {
        method: "PUT",
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(response => response.json())
        .then((todoList) => {
          dispatch({ type: "update-item", item: todoList });
        });
    };
  
  
    return <div>
      <table >
        <thead>
          <tr>
            <td>ID</td>
            <td>Tarea</td>
            <td>¿Completado?</td>
          </tr>
        </thead>
        <tbody>
          {currentList.map((todoList) => {
            return <tr key={todoList.id}>
              <td>{todoList.id}</td>
              <td>{todoList.name}</td>
              {console.log(todoList)}
              <td className="text-center" ><input type="checkbox" defaultChecked={todoList.completed} onChange={(event) => onChange(event, todoList)}></input></td>
              <td><button className="btn btn-danger" onClick={() => onDelete(todoList.id)}>Eliminar</button></td>
              <td><button className="btn btn-info" onClick={() => onEdit(todoList)}>Editar</button></td>
            </tr>
          })}
        </tbody>
      </table>
    </div>
  }

  export default List;