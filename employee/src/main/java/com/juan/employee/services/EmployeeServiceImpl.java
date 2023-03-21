package com.juan.employee.services;

import com.juan.employee.dto.EmployeeDTO;
import com.juan.employee.mappers.EmployeeMapper;
import com.juan.employee.model.Employee;
import com.juan.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeI{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {

        Employee employee = employeeMapper.toEntity(employeeDTO);
        employeeRepository.save(employee);

    }
}
