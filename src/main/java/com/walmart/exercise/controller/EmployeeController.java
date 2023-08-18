package com.walmart.exercise.controller;

import com.walmart.exercise.entity.Book;
import com.walmart.exercise.entity.Employee;
import com.walmart.exercise.service.BookService;
import com.walmart.exercise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeesService;

    @GetMapping
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.ok(employeesService.getEmployees());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getEmployeesById(@PathVariable Long id){
        return ResponseEntity.ok(employeesService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Employee book){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeesService.saveEmployee(book));
    }

}
