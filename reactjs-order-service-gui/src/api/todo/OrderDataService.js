import axios from 'axios'
import {ORDER_API_URL } from '../../Constants'

class OrderDataService {

    getOrderToken(name) {
        //console.log('executed service')
        return axios.get(`${ORDER_API_URL}/users/${name}/`);
        //.then(response => console.info("headers:", response.data));
    }

    createOrder(name, order) {
        //console.log('executed service')
        return axios.post(`${ORDER_API_URL}/users/${name}/`, order);
    }

    retrieveAllOrders(name) {
        //console.log('executed service')
        return axios.get(`${ORDER_API_URL}/users/${name}/orders`);
    }
}

export default new OrderDataService()