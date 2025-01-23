package org.gastpro.api.employees.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.gastpro.api.common.enums.EmployeeStatus;
import org.gastpro.api.common.enums.EmploymentType;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EmployeeDetailForm {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String role;
    private LocalDate hireDate;
    private EmployeeStatus status;
    private Double hourlyRate;
    private Integer restaurantId;
    private EmploymentType employmentType;
}
