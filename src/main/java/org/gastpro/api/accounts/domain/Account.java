package org.gastpro.api.accounts.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.gastpro.api.common.enums.AccountType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "password_hash", length = Integer.MAX_VALUE)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = Integer.MAX_VALUE)
    private AccountType type;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    public void setPasswordHash(String rawPassword) {
        this.passwordHash = new BCryptPasswordEncoder().encode(rawPassword);
    }



}