package org.gastpro.api.common.notification;

import jakarta.mail.MessagingException;
import org.gastpro.api.common.events.RestaurantCreatedEvent;
import org.gastpro.api.common.services.EmailService;
import org.gastpro.api.restaurants.domain.RestaurantService;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailListeners {
    private final EmailService emailService;
    private final RestaurantService restaurantService;
    public EmailListeners(EmailService emailService, RestaurantService restaurantService) {
        this.emailService = emailService;
        this.restaurantService = restaurantService;
    }


    @Async
    @ApplicationModuleListener
    public void on(RestaurantCreatedEvent restaurantCreatedEvent) throws MessagingException {
        System.out.println("Restaurant created event: " + restaurantCreatedEvent);
        emailService.sendRestaurantWelcomeEmail(restaurantCreatedEvent.getResName(), restaurantCreatedEvent.getOwnerEmail(), restaurantCreatedEvent.getOwnerFirstName());
    }
}
