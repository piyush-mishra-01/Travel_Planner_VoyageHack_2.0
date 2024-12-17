import axios from 'axios';

const userService = {
  login: async (email, password) => {
    try {
      const response = await axios.post('/api/login', { email, password });
      return response.data;
    } catch (error) {
      throw error;
    }
  },
  register: async (userData) => {
    try {
      const response = await axios.post('/api/register', userData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },
};

export default userService;
