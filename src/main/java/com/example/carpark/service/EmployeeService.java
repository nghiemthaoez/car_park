package com.example.carpark.service;

import com.example.carpark.entity.Employee;
import com.example.carpark.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployees(){
        try{
            return employeeRepository.findAll();
        }catch (Exception e){
            System.out.println(e);
        }return null;
    }
    public Optional<Employee> getEmployeeById(Long employeeId){
        return employeeRepository.findById(employeeId);
    }
    public Optional<Employee> getEmployeeByAccount(String account){
        return employeeRepository.findByAccount(account);
    }
    public Employee saveEmployee(Employee employee){
        try{
            return employeeRepository.save(employee);
        }catch (Exception e){
            System.out.println(e);
        } return null;
    }
    public Employee editEmployee(Long employeeId,Employee employee) {
        try {
            employee.setEmployeeId(employeeId);
            return employeeRepository.save(employee);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public void deleteEmployee(Long employeeId) throws EmptyResultDataAccessException {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
//        if(!optionalEmployee.isPresent()) {
//            throw new Exception("employee", employeeId.toString());
//        }
//        employeeRepository.deleteById(employeeId);
        try {
            employeeRepository.deleteById(employeeId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
