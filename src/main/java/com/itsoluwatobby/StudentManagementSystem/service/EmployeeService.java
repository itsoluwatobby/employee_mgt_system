package com.itsoluwatobby.StudentManagementSystem.service;

import com.itsoluwatobby.StudentManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee findById(Long id);

    void deleteById(Long employeeId);
}
