package com.crud.service;

import java.util.List;

import com.crud.entity.Employee;

public interface EmployeeService {

public Employee saveEmployee(Employee employee);

public List<Employee> getAllEmployee();

public Employee getEmployeeByID(String ID);

public Employee updateEmployeeById(String emp_id, Employee employee);

public String deleteEmployee(String emp_id);

}
