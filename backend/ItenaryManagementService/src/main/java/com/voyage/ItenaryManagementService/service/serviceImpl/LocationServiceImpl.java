package com.voyage.ItenaryManagementService.service.serviceImpl;

import com.voyage.ItenaryManagementService.model.Location;
import com.voyage.ItenaryManagementService.repository.LocationRepository;
import com.voyage.ItenaryManagementService.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
