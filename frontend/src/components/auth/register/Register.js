import React, { useState } from 'react';
import './Register.scss';

const Register = ({ onLoginClick }) => {
  const [fullname, setFullname] = useState('');
  const [username, setUsername] = useState('');
  const [mobileNumber, setMobileNumber] = useState();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (password !== confirmPassword) {
      alert("Passwords don't match!");
      return;
    }
    console.log('Username:', username);
    console.log('Email:', email);
    console.log('Password:', password);
  };

  return (
    <div className="register-container">
      <form className="register-form" onSubmit={handleSubmit}>
        <h2>Create an Account</h2>

        <label htmlFor="fullname">Full Name</label>
        <input
          type="text"
          id="fullname"
          placeholder="Enter your fullname"
          value={username}
          onChange={(e) => setFullname(e.target.value)}
        />

        <label htmlFor="username">Username</label>
        <input
          type="text"
          id="username"
          placeholder="Enter your username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />

        <label htmlFor="email">Email</label>
        <input
          type="email"
          id="email"
          placeholder="Enter your email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <label htmlFor="mobilenumber">Mobile Number</label>
        <input
          type="tel"
          id="mobilenumber"
          placeholder="Enter your mobile number"
          value={mobileNumber}
          onChange={(e) => setMobileNumber(e.target.value)}
          pattern="^\d{10}$"  // Optional: to enforce a 10-digit mobile number pattern (adjust length as needed)
          required
        />

        <label htmlFor="password">Password</label>
        <input
          type="password"
          id="password"
          placeholder="Enter your password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <label htmlFor="confirm-password">Confirm Password</label>
        <input
          type="password"
          id="confirm-password"
          placeholder="Confirm your password"
          value={confirmPassword}
          onChange={(e) => setConfirmPassword(e.target.value)}
        />

        <button type="submit" className="register-button">Register</button>

        <p className="login-link">
          Already have an account?{' '}
          <span
            role="button"
            tabIndex={0}
            onClick={onLoginClick}
            onKeyDown={(e) => {
              if (e.key === 'Enter' || e.key === ' ') onLoginClick();
            }}
            style={{ color: '#007bff', cursor: 'pointer', textDecoration: 'underline' }}
          >
            Login here
          </span>
        </p>
      </form>
    </div>
  );
};

export default Register;
