package com.itsoluwatobby.StudentManagementSystem.repository;

import com.itsoluwatobby.StudentManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
