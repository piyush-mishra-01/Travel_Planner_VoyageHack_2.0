// src/utils/validators.js

// Example email validation function
export const validateEmail = (email) => {
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    return emailRegex.test(email);
  };
  
  // Example password validation function
  export const validatePassword = (password) => {
    return password.length >= 6; // Ensure the password is at least 6 characters long
  };
  