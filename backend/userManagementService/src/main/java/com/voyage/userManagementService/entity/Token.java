package com.voyage.userManagementService.entity;


import com.voyage.userManagementService.enums.TokenType;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Token {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public Boolean revoked;

    public Boolean expired;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
