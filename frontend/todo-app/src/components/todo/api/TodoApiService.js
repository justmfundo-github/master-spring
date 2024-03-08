import { apiClient } from "./ApiClient";

// export function retrieveHelloWorldBean() {
//   return axios.get("http://localhost:8080/hello-world-bean");
// }

//another way to create the function in shorthand
export const retrieveHelloWorldBean = () => apiClient.get("/hello-world-bean");

//export const retrieveHelloWorldPathVariable = (username) => axios.get(`http://localhost:8080/hello-world/path-variable/${username}`);

//after creating the constant for baseUrl using axios, we can now replace axios.get with apiClient.get
export const retrieveAllTodosForUsernameApi = (username) => apiClient.get(`/users/${username}/todos`);

export const deleteTodoApi = (username, id) => apiClient.delete(`/users/${username}/todos/${id}`);

export const retrieveTodoApi = (username, id) => apiClient.get(`/users/${username}/todos/${id}`);

export const updateTodoApi = (username, id, todo) => apiClient.put(`/users/${username}/todos/${id}`, todo);

export const createTodoApi = (username, todo) => apiClient.post(`/users/${username}/todos`, todo);
