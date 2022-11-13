package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this is a controller that will receive requests coming in and saving the response
@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    // ResponseEntity returns HTTP response
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees=employeeService.findAllEmployees();
        return new ResponseEntity<>(employees/*body*/, HttpStatus.OK/*status code*/);

    }
    @GetMapping("/find/{id}")
    // ResponseEntity returns HTTP response
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")/*must be same as in URL*/ Long id){
        Employee employee=employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee/*body*/, HttpStatus.OK/*status code*/);

    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee /*will come from URL*/){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?/*doesn't return anything*/> deleteEmployee(@PathVariable("id")/*must be same as in URL*/ Long id){
         employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
