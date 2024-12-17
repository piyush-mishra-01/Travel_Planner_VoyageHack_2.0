import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { UserManagement, ItineraryManagement, DestinationInsights, BudgetManagement, BookingIntegration, RecommendationEngine, Collaboration, Notifications } from './pages';

const Routes = () => {
  return (
    <Switch>
      <Route path="/user-management" component={UserManagement} />
      <Route path="/itinerary-management" component={ItineraryManagement} />
      <Route path="/destination-insights" component={DestinationInsights} />
      <Route path="/budget-management" component={BudgetManagement} />
      <Route path="/booking-integration" component={BookingIntegration} />
      <Route path="/recommendation-engine" component={RecommendationEngine} />
      <Route path="/collaboration" component={Collaboration} />
      <Route path="/notifications" component={Notifications} />
    </Switch>
  );
};

export default Routes;
