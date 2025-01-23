package org.gastpro.api.restaurants.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "restaurant_details")
public class RestaurantDetail {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name = "address", length = Integer.MAX_VALUE)
    private String address;

    @Column(name = "city", length = Integer.MAX_VALUE)
    private String city;

    @Column(name = "state", length = Integer.MAX_VALUE)
    private String state;

    @Column(name = "zip", length = Integer.MAX_VALUE)
    private String zip;

    @Column(name = "phone_number", length = Integer.MAX_VALUE)
    private String phoneNumber;

    @Column(name = "cuisine", length = Integer.MAX_VALUE)
    private String cuisine;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

}