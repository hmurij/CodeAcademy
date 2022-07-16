import React, { useState } from "react";

const AuthContext = React.createContext({
  userName: "",
  authorities: "",
  token: "",
  isLoggedIn: false,
  login: (loginResponse) => {},
  logout: () => {},
});

export const AuthContextProvider = (props) => {
  const [token, setToken] = useState(null);
  const [userName, setUserName] = useState("");
  const [authorities, setAuthorities] = useState("");

  const userIsLoggedIn = !!token;

  const loginHandler = ({ userName, authorities, jwt }) => {
    setUserName(userName);
    setAuthorities(authorities);
    setToken(jwt);
  };

  const logoutHandler = () => {
    setToken(null);
  };

  const contextValue = {
    userName: userName,
    authorities: authorities,
    token: token,
    isLoggedIn: userIsLoggedIn,
    login: loginHandler,
    logout: logoutHandler,
  };

  return (
    <AuthContext.Provider value={contextValue}>
      {props.children}
    </AuthContext.Provider>
  );
};

export default AuthContext;
