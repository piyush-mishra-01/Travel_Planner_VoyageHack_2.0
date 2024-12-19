import React, { useState } from 'react';
import './ForgotPassword.scss';

const ForgotPassword = () => {
  const [email, setEmail] = useState('');
  const [submitted, setSubmitted] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    // Simulate API request or validation
    console.log('Password reset link sent to:', email);
    setSubmitted(true);
  };

  return (
    <div className="forgot-password-container">
      <div className="forgot-password-card">
        <h2>Forgot Password</h2>
        {submitted ? (
          <p className="success-message">
            A password reset link has been sent to <strong>{email}</strong>.
          </p>
        ) : (
          <form onSubmit={handleSubmit}>
            <label htmlFor="email">Email Address</label>
            <input
              type="email"
              id="email"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <button type="submit" className="reset-button">
              Send Reset Link
            </button>
          </form>
        )}
        <div className="back-to-login">
          <a href="/user-management">Back to Login</a>
        </div>
      </div>
    </div>
  );
};

export default ForgotPassword;
