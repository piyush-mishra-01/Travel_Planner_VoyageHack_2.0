package com.voyage.ItenaryManagementService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CollaborationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sender;

    private Long receiverId;

    @ManyToOne
    @JoinColumn(name = "itinerary_id", nullable = false)
    private CustomItinerary customItinerary;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

}