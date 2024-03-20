import { apiClient } from "./ApiClient";

// export function retrieveHelloWorldBean() {
//   return axios.get("http://localhost:8080/hello-world-bean");
// }

//another way to create the function in shorthand
export const retrieveHelloWorldBean = () => apiClient.get("/hello-world-bean");

//export const retrieveHelloWorldPathVariable = (username) => axios.get(`http://localhost:8080/hello-world/path-variable/${username}`);

//after creating the constant for baseUrl using axios, we can now replace axios.get with apiClient.get
export const retrieveHelloWorldPathVariable = (username, token) =>
  apiClient.get(`/hello-world/path-variable/${username}`, {
    headers: {
      Authorization: token,
    },
  });
