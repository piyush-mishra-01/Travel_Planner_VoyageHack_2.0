import React, { useState } from 'react';
import './Login.scss';

const Login = ({ onClose, onRegisterClick,onForgotPasswordClick }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword, setShowPassword] = useState(false); // State to toggle password visibility

  // Function to toggle password visibility
  const togglePasswordVisibility = () => {
    setShowPassword((prevState) => !prevState);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Email:', email);
    console.log('Password:', password);
  };

  return (
    <div className="login-container">
      <form className="login-form" onSubmit={handleSubmit}>
        <h2>Login to your account</h2>

        {/* Email Input */}
        <label htmlFor="email">Email / Username</label>
        <div className='user-field'>
        <input
          type="email"
          id="email"
          placeholder="Email/Username"
          value={email}
          required
          onChange={(e) => setEmail(e.target.value)}
        /></div>

        {/* Password Input with Toggle */}
        <label htmlFor="password">Password</label>
        <div className="password-field">
          <input
            type={showPassword ? 'text' : 'password'} // Toggle input type
            id="password"
            placeholder="Password"
            required
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <span className="eye-icon" onClick={togglePasswordVisibility}>
            {showPassword ? '🙈' : '👁️'} {/* Change icon dynamically */}
          </span>
        </div>

        {/* Forgot Password */}
        <div className="forgot-password">
          {/* <a href="/forgotpassword"> */}
          <span
            className="forgotpassword-link"
            onClick={onForgotPasswordClick}
            role="button"
           
          >
            Forgot Password?
          </span>
          {/* </a> */}
        </div>

        {/* Submit Button */}
        <button type="submit" className="login-button"><a href='/userhomepage'>Login →</a></button>

        {/* Additional Links */}
        <div className="additional-links">
          <p>Don’t have an account? </p>
          <span
            className="register-link"
            onClick={onRegisterClick}
            role="button"
          >
            Register with us
          </span>
        </div>
      </form>
    </div>
  );
};

export default Login;
