package com.juan.employee.controller;

import com.juan.employee.dto.EmployeeDTO;
import com.juan.employee.dto.Message;
import com.juan.employee.model.Employee;
import com.juan.employee.repository.EmployeeRepository;
import com.juan.employee.services.EmployeeService;
import com.juan.employee.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private Map<String,Object> response = new HashMap<>();
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    //Get all Employees
    //@GetMapping("/employees")
    //public List<Employee> getAllEmployees(){

      //  return employeeRepository.findAll();
    //}
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll(){

        return (ResponseEntity.ok(employeeService.finAll()));
    }

    @GetMapping("/id")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        response.clear();
        response.put("Employee", employeeService.getEmployeeById(id));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Create Employee
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        response.clear();
        //employeeService.createEmployee(employeeDTO);
        employeeServiceImpl.saveEmployee(employeeDTO);
        response.put("message", "Employee create OK");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
   }
   //Delete Employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployeeByID (@PathVariable("id") long idEmployee){
        if(!employeeService.existById(idEmployee))
            return new ResponseEntity<>(new Message("Employee No Exist"), HttpStatus.NOT_FOUND);
            employeeService.deleteEmployeeByID(idEmployee);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    //Update Employee
    @PutMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){

        return ResponseEntity.ok(id);
    }

}
