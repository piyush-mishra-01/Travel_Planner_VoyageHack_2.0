import React, { useState } from 'react';
import './Profile.css'; // Import the CSS file for styling

const Profile = () => {
  // Sample data for profile (you can replace these with actual data from your backend)
  const [name, setName] = useState('John Doe');
  const [email, setEmail] = useState('john.doe@example.com');
  const [mobileNumber, setMobileNumber] = useState('123-456-7890');
  const [profilePic, setProfilePic] = useState(null); // Placeholder for profile picture

  // Handle file upload for profile picture
  const handleFileChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      setProfilePic(URL.createObjectURL(file));
    }
  };

  return (
    <div className="profile-container">
      <div className="profile-card">
        <h2 className="profile-heading">Profile</h2>
        <div className="profile-picture-container">
          <label htmlFor="profilePic" className="profile-picture-label">
            {profilePic ? (
              <img src={profilePic} alt="Profile" className="profile-picture" />
            ) : (
              <span className="profile-picture-placeholder">Add Profile Picture</span>
            )}
          </label>
          <input
            type="file"
            id="profilePic"
            accept="image/*"
            onChange={handleFileChange}
            className="profile-picture-input"
          />
        </div>
        <form className="profile-form">
          <div className="form-group">
            <label htmlFor="name">Name</label>
            <input
              type="text"
              id="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="Enter your name"
            />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Enter your email"
            />
          </div>
          <div className="form-group">
            <label htmlFor="mobileNumber">Mobile Number</label>
            <input
              type="tel"
              id="mobileNumber"
              value={mobileNumber}
              onChange={(e) => setMobileNumber(e.target.value)}
              placeholder="Enter your mobile number"
              pattern="^\d{10}$"
            />
          </div>
          <button type="submit" className="save-button">Save Changes</button>
        </form>
      </div>
    </div>
  );
};

export default Profile;
