package org.gastpro.api.employees.domain;

import org.gastpro.api.accounts.domain.Account;
import org.gastpro.api.accounts.domain.AccountService;
import org.gastpro.api.employees.domain.dto.EmployeeDetailForm;
import org.gastpro.api.restaurants.domain.Restaurant;
import org.gastpro.api.restaurants.domain.RestaurantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AccountService accountService;
    private final RestaurantService restaurantService;
    public EmployeeService(EmployeeRepository employeeRepository, AccountService accountService, RestaurantService restaurantService) {
        this.employeeRepository = employeeRepository;
        this.accountService = accountService;
        this.restaurantService = restaurantService;
    }

    @Transactional
    public Employee createEmptyEmployee(Integer accountId) {
        Employee employee = new Employee();
        Account account = accountService.findAccountById(accountId);
        employee.setAccount(account);
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Employee updateEmployee(EmployeeDetailForm employeeDetailForm) {
        Employee employee = getEmployee(employeeDetailForm.getEmployeeId());
        Restaurant restaurant = restaurantService.getRestaurantById(employeeDetailForm.getRestaurantId());
        employee.setFirstName(employeeDetailForm.getFirstName());
        employee.setLastName(employeeDetailForm.getLastName());
        employee.setEmploymentType(employeeDetailForm.getEmploymentType());
        employee.setHourlyRate(employeeDetailForm.getHourlyRate());
        employee.setRestaurant(restaurant);
        employee.setHireDate(employeeDetailForm.getHireDate());
        employee.setStatus(employeeDetailForm.getStatus());
        employee.setRole(employeeDetailForm.getRole());
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(Integer restaurantId) {
        return employeeRepository.findByRestaurant_Id(restaurantId);
    }


}
