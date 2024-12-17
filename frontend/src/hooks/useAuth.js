import { useState } from 'react';
import userService from '../services/userService';

const useAuth = () => {
  const [user, setUser] = useState(null);

  const login = async (email, password) => {
    try {
      const data = await userService.login(email, password);
      setUser(data);
    } catch (error) {
      console.error('Login failed', error);
    }
  };

  const logout = () => {
    setUser(null);
  };

  return { user, login, logout };
};

export default useAuth;
