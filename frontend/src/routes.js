import React from 'react';
import { Routes, Route } from 'react-router-dom';
import {
  UserManagement,
  ItineraryManagement,
  DestinationInsights,
  BudgetManagement,
  BookingIntegration,
  RecommendationEngine,
  Collaboration,
  Notifications,
} from './pages';
import Register from './pages/UserManagement/Register'; // Correct Register import

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/user-management" element={<UserManagement />} />
      <Route path="/itinerary-management" element={<ItineraryManagement />} />
      <Route path="/destination-insights" element={<DestinationInsights />} />
      <Route path="/budget-management" element={<BudgetManagement />} />
      <Route path="/booking-integration" element={<BookingIntegration />} />
      <Route path="/recommendation-engine" element={<RecommendationEngine />} />
      <Route path="/collaboration" element={<Collaboration />} />
      <Route path="/notifications" element={<Notifications />} />
      <Route path="/register" element={<Register />} />
    </Routes>
  );
};

export default AppRoutes;
