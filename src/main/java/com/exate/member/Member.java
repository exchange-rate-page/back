package com.exate.member;

import com.exate.security.oauth.OAuthServer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OAuthServer oAuthServer;
}
