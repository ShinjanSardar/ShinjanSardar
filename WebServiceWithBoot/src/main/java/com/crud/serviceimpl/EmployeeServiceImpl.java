package com.crud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
import com.crud.repository.EmployeeRegistration;
import com.crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRegistration empregrepo;

	@Override
	public Employee saveEmployee(Employee employee) {

		Employee newEmployee = empregrepo.save(employee);

		return newEmployee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allEmployee = empregrepo.findAll();

		return allEmployee;
	}

	@Override
	public Employee updateEmployeeById(String emp_id, Employee employee) {
		Employee returnval = empregrepo.save(employee);
		return returnval;
	}

	@Override
	public String deleteEmployee(String emp_id) {
		empregrepo.deleteById(emp_id);
		boolean _return=empregrepo.existsById(emp_id);
		if(_return==false) {
			return emp_id;
		}
		else {
			return "can not delete id";
		}
	}

	

	@Override
	public Employee getEmployeeByID(String ID) {
		Employee employee = empregrepo.getById(ID);;
		return employee;
	}

}
