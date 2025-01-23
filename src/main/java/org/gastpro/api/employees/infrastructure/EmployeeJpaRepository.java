package org.gastpro.api.employees.infrastructure;

import org.gastpro.api.employees.domain.Employee;
import org.gastpro.api.employees.domain.EmployeeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>, EmployeeRepository {
    List<Employee> findByRestaurant_Id(Integer id);

}