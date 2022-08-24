package com.example.app.cronexamples.service;

import com.example.app.cronexamples.domain.Employee;
import com.example.app.cronexamples.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{

    private final EmployeeRepository employeeRepositroy;

    @Override
    public List<Employee> findAll() {
        return  employeeRepositroy.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepositroy.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return  employeeRepositroy.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepositroy.deleteById(id);
    }
}
