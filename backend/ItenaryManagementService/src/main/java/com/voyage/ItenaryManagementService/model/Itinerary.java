package com.voyage.ItenaryManagementService.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "itinerary")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itinerary_id")
    private Long itineraryId;

    private String userId; // Assuming 'User' is the class fetched from another microservice

    private String tripName;

    private LocalDate tripStartDate;

    private LocalDate tripEndDate;

    private String status; // Active or Draft

    private String startTime;

    private String endTime;

}
