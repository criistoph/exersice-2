package com.walmart.exercise.service;

import com.walmart.exercise.entity.Book;
import com.walmart.exercise.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    public List<Employee> getEmployees();

    public Employee getEmployeeById(Long id);


    public Employee saveEmployee(Employee employee);

}
