package com.juan.employee.services;

import com.juan.employee.dto.EmployeeDTO;
import com.juan.employee.model.Employee;
import com.juan.employee.mappers.EmployeeMapper;
import com.juan.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDTO getEmployeeById(Long id){
        return employeeMapper.toDTO(employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found"))
        );
    }
    public List<Employee> finAll() {
        return employeeRepository.findAll();
    }
    public Boolean existById(Long id){
        return employeeRepository.existsById(id);
    }
    /*@Transactional
    public void createEmployee (EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employeeRepository.save(employee);
    }

     */
    public void createEmployee (Employee employee) {
       // Employee employee = employeeMapper.toEntity(employee);
        employeeRepository.save(employee);
    }
    public void deleteEmployeeByID(Long id){ employeeRepository.deleteById(id);}
    public void Employee (Employee employee){
        employeeRepository.save(employee);
    }


}
