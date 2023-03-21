package com.juan.employee.mappers;

import com.juan.employee.dto.EmployeeDTO;
import com.juan.employee.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public  interface  EmployeeMapper {

      //  public abstract Employee toEntity(EmployeeDTO employeeDTO);
       // public abstract EmployeeDTO toDTO(Employee employee);
        Employee toEntity(EmployeeDTO employeeDTO);
        EmployeeDTO toDTO(Employee employee);
}
