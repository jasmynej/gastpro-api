package org.gastpro.api.employees.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.gastpro.api.accounts.domain.Account;
import org.gastpro.api.common.enums.EmployeeStatus;
import org.gastpro.api.common.enums.EmploymentType;
import org.gastpro.api.restaurants.domain.Restaurant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Account account;

    @Column(name = "first_name", length = Integer.MAX_VALUE)
    private String firstName;

    @Column(name = "last_name", length = Integer.MAX_VALUE)
    private String lastName;

    @Column(name = "role", length = Integer.MAX_VALUE)
    private String role;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = Integer.MAX_VALUE)
    private EmployeeStatus status;

    @Column(name = "hourly_rate", length = Integer.MAX_VALUE)
    private Double hourlyRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_type", length = Integer.MAX_VALUE)
    private EmploymentType employmentType;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;


    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;



}