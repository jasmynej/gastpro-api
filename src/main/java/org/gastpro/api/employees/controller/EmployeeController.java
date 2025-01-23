package org.gastpro.api.employees.controller;

import org.gastpro.api.employees.domain.Employee;
import org.gastpro.api.employees.domain.EmployeeService;
import org.gastpro.api.employees.domain.dto.EmployeeDetailForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/add-details")
    public Employee addEmployeeDetails(@RequestBody EmployeeDetailForm employeeDetailForm) {
        System.out.println(employeeDetailForm);
        return employeeService.updateEmployee(employeeDetailForm);
    }


}
