package org.gastpro.api.restaurants.controller;

import org.gastpro.api.employees.domain.Employee;
import org.gastpro.api.employees.domain.EmployeeService;
import org.gastpro.api.restaurants.domain.Restaurant;
import org.gastpro.api.restaurants.domain.RestaurantDetail;
import org.gastpro.api.restaurants.domain.RestaurantService;
import org.gastpro.api.restaurants.domain.dto.RestaurantCreationForm;
import org.gastpro.api.restaurants.domain.dto.RestaurantDetailForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final EmployeeService employeeService;

    public RestaurantController(RestaurantService restaurantService, EmployeeService employeeService) {
        this.restaurantService = restaurantService;
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public Restaurant createRestaurant(@RequestBody RestaurantCreationForm restaurantCreationForm) {
        return restaurantService.createRestaurant(restaurantCreationForm);
    }

    @PostMapping("/add-details")
    public RestaurantDetail addRestaurantDetails(@RequestBody RestaurantDetailForm restaurantDetailForm) {
        return restaurantService.updateDetail(restaurantDetailForm);
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable int id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployees(@PathVariable int id) {
       return employeeService.getEmployees(id);
    }
}
