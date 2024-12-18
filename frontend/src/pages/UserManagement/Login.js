import React, { useState } from 'react';
import './Login.scss';

const Login = () => {
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
        <input
          type="email"
          id="email"
          placeholder="Email/Username"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        {/* Password Input with Toggle */}
        <label htmlFor="password">Password</label>
        <div className="password-field">
          <input
            type={showPassword ? 'text' : 'password'} // Toggle input type
            id="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <span className="eye-icon" onClick={togglePasswordVisibility}>
            {showPassword ? '🙈' : '👁️'} {/* Change icon dynamically */}
          </span>
        </div>

        {/* Forgot Password */}
        <div className="forgot-password">
          <a href="/forgotpassword">Forgot Password?</a>
        </div>

        {/* Submit Button */}
        <button type="submit" className="login-button">Login →</button>

        {/* Additional Links */}
        <div className="additional-links">
          <p>Don’t have an account? <a href="/register">Register with us</a></p>
        </div>
      </form>
    </div>
  );
};

export default Login;
