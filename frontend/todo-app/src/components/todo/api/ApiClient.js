import axios from "axios";

//creating a common variable for axios
export const apiClient = axios.create({
  baseURL: "http://localhost:8080",
});
