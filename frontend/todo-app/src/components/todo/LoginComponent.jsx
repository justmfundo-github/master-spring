import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function LoginComponent() {
  const [username, setUsername] = useState("in28minutes");
  const [password, setPassword] = useState("");

  const [showErrorMessage, setShowErrorMessage] = useState(false);
  const navigate = useNavigate();
  const authContext = useAuth();

  function handleUsernameChange(event) {
    console.log(event.target.value);
    setUsername(event.target.value);
  }

  function handlePasswordChange(event) {
    console.log(event.target.value);
    setPassword(event.target.value);
  }

  async function handleSubmit() {
    if (await authContext.login(username, password)) {
      navigate(`/welcome/${username}`);
    } else {
      setShowErrorMessage(true);
    }
  }
  /*
  // These two functions have been added in line in a simpler manner
  function SuccessMessageComponent() {
    if (showSuccessMessage) {
      return <div className="successMessage">Authenticated Successfully</div>;
    } else {
      return null;
    }
  }

  function ErrorMessageComponent() {
    if (showErrorMessage) {
      return <div className="errorMessage">Authenticated Failed. Please check your credentials</div>;
    } else {
      return null;
    }
  } */

  return (
    <div className="Login">
      <h1>Time to login</h1>
      {showErrorMessage && <div className="errorMessage">Authenticated Failed. Please check your credentials</div>}
      <div className="LoginForm">
        <div>
          <label>User Name</label>
          <input type="text" name="username" value={username} onChange={handleUsernameChange} />
        </div>
        <div>
          <label>Password</label>
          <input type="password" name="password" value={password} onChange={handlePasswordChange} />
        </div>
        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}
