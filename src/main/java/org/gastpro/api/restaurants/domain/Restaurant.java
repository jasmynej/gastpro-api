package org.gastpro.api.restaurants.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.gastpro.api.employees.domain.Employee;
import org.gastpro.api.menu.domain.Menu;
import org.gastpro.api.owners.domain.Owner;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "owner")
    private Owner owner;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private RestaurantDetail restaurantDetail;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true)
    @JsonManagedReference
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true)
    @JsonManagedReference
    private List<Employee> employees = new ArrayList<>();

}