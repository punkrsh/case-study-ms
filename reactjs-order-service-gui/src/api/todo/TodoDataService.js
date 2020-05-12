import axios from 'axios'
import { JPA_API_URL,ORDER_API_URL } from '../../Constants'

class TodoDataService {

    retrieveAllTodos(name) {
        //console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${name}/todos`);
    }

    retrieveTodo(name, id) {
        //console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${name}/todos/${id}`);
    }

    deleteTodo(name, id) {
        //console.log('executed service')
        return axios.delete(`${JPA_API_URL}/users/${name}/todos/${id}`);
    }

    updateTodo(name, id, todo) {
        //console.log('executed service')
        return axios.put(`${JPA_API_URL}/users/${name}/todos/${id}`, todo);
    }

    createTodo(name, todo) {
        //console.log('executed service')
        return axios.post(`${JPA_API_URL}/users/${name}/todos/`, todo);
    }

    createOrder(name, todo) {
        console.log('executed service')
        return axios.get(`${ORDER_API_URL}/users/puneet/`);
    }
}

export default new TodoDataService()