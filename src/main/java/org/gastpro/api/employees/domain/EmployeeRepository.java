package org.gastpro.api.employees.domain;

import org.gastpro.api.restaurants.domain.Restaurant;

import java.util.List;

public interface EmployeeRepository {
    Employee findById(int id);
    Employee save(Employee employee);
    List<Employee> findByRestaurant_Id(Integer id);

}
