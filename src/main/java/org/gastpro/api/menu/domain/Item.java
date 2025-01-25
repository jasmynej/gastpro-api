package org.gastpro.api.menu.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.gastpro.api.common.enums.ItemCategory;
import org.gastpro.api.menu.domain.dto.NewItemForm;
import org.gastpro.api.restaurants.domain.Restaurant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = Integer.MAX_VALUE)
    private ItemCategory category;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    public static Item createFromForm(NewItemForm newItemForm, Restaurant restaurant) {
        Item item = new Item();
        item.setCategory(newItemForm.getCategory());
        item.setName(newItemForm.getName());
        item.setDescription(newItemForm.getDescription());
        item.setRestaurant(restaurant);
        return item;
    }

}