package com.voyage.userManagementService.repository;

import com.voyage.userManagementService.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {
}
