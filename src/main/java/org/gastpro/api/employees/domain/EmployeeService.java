package org.gastpro.api.employees.domain;

import org.gastpro.api.accounts.domain.Account;
import org.gastpro.api.accounts.domain.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AccountService accountService;
    public EmployeeService(EmployeeRepository employeeRepository, AccountService accountService) {
        this.employeeRepository = employeeRepository;
        this.accountService = accountService;
    }

    @Transactional
    public Employee createEmptyEmployee(Integer accountId) {
        Employee employee = new Employee();
        Account account = accountService.findAccountById(accountId);
        employee.setAccount(account);
        return employeeRepository.save(employee);
    }


}
