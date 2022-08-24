package com.example.app.cronexamples.service;

import com.example.app.cronexamples.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> findAll();

    public Employee findById(Long id);

    public  Employee save(Employee employee);

    public void delete(Long id);
}
