import React from 'react';
import Form from "./componentes/todo/Form";
import FormGrupo from "./componentes/groupTodoList/FormGrop"
import List from "./componentes/todo/List"
import ListGroup from "./componentes/groupTodoList/ListGruop"
import StoreProvider from "./componentes/todo/StoreProvider";



function App() {
  return <div>
    <StoreProvider >
      <div className="header">
        <h3>To-Do List</h3>
        <FormGrupo />
        <ListGroup />
        <Form/>
       
      </div>
      
      <div className="tareas card border-info mb-3">
        <List />
        
      </div>
    </StoreProvider>
  </div>

}

export default App;