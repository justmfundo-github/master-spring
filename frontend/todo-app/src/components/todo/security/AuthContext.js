import { createContext, useContext, useState } from "react";
import { executeJWTAuthenticationService } from "../api/AuthenticationApiService";
import { apiClient } from "../api/ApiClient";

//Create a Context
export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

//Share the created context with other components
export default function AuthProvider({ children }) {
  //Put some state in the context

  const [isAuthenticated, setAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);
  const [token, setToken] = useState(null);

  // function login(username, password) {
  //   if (username === "in28minutes" && password === "dummy") {
  //     setAuthenticated(true);
  //     setUsername(username);
  //     return true;
  //   } else {
  //     setAuthenticated(false);
  //     setUsername(null);
  //     return false;
  //   }
  // }

  // async function login(username, password) {
  //   const basicAuthToken = "Basic " + window.btoa(username + ":" + password);

  //   try {
  //     const response = await executeBasicAuthenticationService(basicAuthToken);

  //     if (response.status == 200) {
  //       setAuthenticated(true);
  //       setUsername(username);
  //       setToken(basicAuthToken);

  //       apiClient.interceptors.request.use((config) => {
  //         console.log("Intercepting and adding a token");
  //         config.headers.Authorization = basicAuthToken;
  //         return config;
  //       });

  //       return true;
  //     } else {
  //       logout();
  //       return false;
  //     }
  //   } catch (error) {
  //     logout();
  //     return false;
  //   }
  // }

  async function login(username, password) {
    try {
      const response = await executeJWTAuthenticationService(username, password);

      if (response.status == 200) {
        const jwtToken = "Bearer " + response.data.token;

        setAuthenticated(true);
        setUsername(username);
        setToken(jwtToken);

        apiClient.interceptors.request.use((config) => {
          console.log("Intercepting and adding a token");
          config.headers.Authorization = jwtToken;
          return config;
        });

        return true;
      } else {
        logout();
        return false;
      }
    } catch (error) {
      logout();
      return false;
    }
  }

  function logout() {
    setAuthenticated(false);
    setUsername(null);
    setToken(null);
  }

  return <AuthContext.Provider value={{ isAuthenticated, login, logout, username, token }}>{children}</AuthContext.Provider>;
}
