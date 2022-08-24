package com.example.app.cronexamples.repository;

import com.example.app.cronexamples.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
