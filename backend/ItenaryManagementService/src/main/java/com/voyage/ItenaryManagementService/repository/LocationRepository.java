package com.voyage.ItenaryManagementService.repository;

import com.voyage.ItenaryManagementService.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> findByLocationName(String name);
}

