function reducergroup(state, action) {
    switch (action.type) {
        case 'todolist':
            const todoList = state.todoList;
            todoList.list = action.list;
            return { ...state, todoList: todoList };

        default:
            return state;
    }
}
export default reducergroup;