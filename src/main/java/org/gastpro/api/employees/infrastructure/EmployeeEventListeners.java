package org.gastpro.api.employees.infrastructure;

import jakarta.mail.MessagingException;
import org.gastpro.api.common.enums.AccountType;
import org.gastpro.api.common.events.AccountCreationEvent;
import org.gastpro.api.common.services.EmailService;
import org.gastpro.api.employees.domain.EmployeeService;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventListeners {
    private final EmployeeService employeeService;
    private final EmailService emailService;

    public EmployeeEventListeners(EmployeeService employeeService, EmailService emailService) {
        this.employeeService = employeeService;
        this.emailService = emailService;
    }

    @ApplicationModuleListener
    public void on(AccountCreationEvent accountCreationEvent) throws MessagingException {
        if (accountCreationEvent.getAccountType() == AccountType.EMPLOYEE) {
            System.out.println("Account creation event for Employee: " + accountCreationEvent);
            employeeService.createEmptyEmployee(accountCreationEvent.getAccountId());
            emailService.sendEmployeeOnboardReminder(accountCreationEvent.getEmail());
        }
    }
}
