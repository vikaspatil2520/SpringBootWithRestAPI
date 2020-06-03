package com.practice.springbootbasics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springbootbasics.beans.Employee;
import com.practice.springbootbasics.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findByName(String ename) {
		
		return employeeRepository.findByEname(ename);
	}

	@Override
	public Optional<Employee> findEmployeeById(Integer id) {
		System.out.println("ID:"+id);
		return employeeRepository.findById(id);
	}

	@Override
	public String deleteEmployeeById(Integer id) {

		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			employeeRepository.deleteById(id);
			return "employee deleted sucessfully for "+id;
		}

		return "employee doesnot exist";

	}

	@Override
	public Employee updateEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee findOneEmpById(Integer id) {
		try {
			return employeeRepository.findById(id).get();
		}catch(Exception e)
		{
			return null;
		}
		
	}

}
