package com.example.carpark.controller;

import com.example.carpark.entity.Employee;
import com.example.carpark.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/findbyId/{employeeId}")
    public ResponseEntity getEmployeeById(@PathVariable Long employeeId){
        return  new ResponseEntity(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }
    @PostMapping("/save")
    public  ResponseEntity createEmployee(@RequestBody Employee employee ){
        try{
            Employee employee1 = employeeService.saveEmployee(employee);
            if(employee1 == null){
                return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }else {
                return  new ResponseEntity(null,HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{employeeId}")
    public ResponseEntity editEmployee(@PathVariable Long employeeId,@RequestBody Employee employee){
        return new ResponseEntity(employeeService.editEmployee(employeeId,employee),HttpStatus.OK);
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity deleteEmployee (@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return  new ResponseEntity("Delete success",HttpStatus.OK);
    }
}