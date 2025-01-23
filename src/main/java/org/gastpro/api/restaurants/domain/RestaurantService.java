package org.gastpro.api.restaurants.domain;

import org.gastpro.api.common.events.RestaurantCreatedEvent;
import org.gastpro.api.owners.domain.Owner;
import org.gastpro.api.owners.domain.OwnerService;
import org.gastpro.api.restaurants.domain.dto.RestaurantCreationForm;
import org.gastpro.api.restaurants.domain.dto.RestaurantDetailForm;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final OwnerService ownerService;
    private final ApplicationEventPublisher eventPublisher;
    private final RestaurantDetailRepository restaurantDetailRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, OwnerService ownerService, ApplicationEventPublisher eventPublisher, RestaurantDetailRepository restaurantDetailRepository) {
        this.restaurantRepository = restaurantRepository;
        this.ownerService = ownerService;
        this.eventPublisher = eventPublisher;
        this.restaurantDetailRepository = restaurantDetailRepository;
    }

    public Restaurant getRestaurantById(Integer restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }

    public RestaurantDetail createEmptyRestaurantDetail(Integer restaurantId) {
        RestaurantDetail restaurantDetail = new RestaurantDetail();
        restaurantDetail.setId(restaurantId);
        return restaurantDetailRepository.save(restaurantDetail);
    }

    @Transactional
    public Restaurant createRestaurant(RestaurantCreationForm restaurantCreationForm) {
        Restaurant newRestaurant = new Restaurant();
        Owner owner = ownerService.getOwnerById(restaurantCreationForm.getOwnerId());

        newRestaurant.setName(restaurantCreationForm.getName());
        newRestaurant.setOwner(owner);

        // Initialize the detail and link it to the restaurant
        RestaurantDetail restaurantDetail = new RestaurantDetail();
        restaurantDetail.setRestaurant(newRestaurant);  // Automatically sets the shared PK

        newRestaurant.setRestaurantDetail(restaurantDetail);

        newRestaurant = restaurantRepository.save(newRestaurant);

        // Publish event after successful transaction
        RestaurantCreatedEvent restaurantCreatedEvent = new RestaurantCreatedEvent(
                newRestaurant.getName(),
                newRestaurant.getId(),
                owner.getAccounts().getEmail(),
                owner.getFirstName()
        );
        eventPublisher.publishEvent(restaurantCreatedEvent);

        return newRestaurant;
    }



    public RestaurantDetail updateDetail(RestaurantDetailForm restaurantDetailForm) {
        RestaurantDetail detail = restaurantDetailRepository.findById(restaurantDetailForm.getRestaurantId());
        detail.setAddress(restaurantDetailForm.getAddress());
        detail.setCity(restaurantDetailForm.getCity());
        detail.setPhoneNumber(restaurantDetailForm.getPhoneNumber());
        detail.setState(restaurantDetailForm.getState());
        detail.setZip(restaurantDetailForm.getZip());
        detail.setCuisine(restaurantDetailForm.getCuisine());
        return restaurantDetailRepository.save(detail);
    }

}
