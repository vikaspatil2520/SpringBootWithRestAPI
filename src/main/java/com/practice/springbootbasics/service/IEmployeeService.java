package com.practice.springbootbasics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.springbootbasics.beans.Employee;

@Service
public interface IEmployeeService {

	List<Employee> getAllEmployee();

	List<Employee> findByName(String ename);

	Optional<Employee> findEmployeeById(Integer id);

	Employee addEmployee(Employee emp);

	String deleteEmployeeById(Integer id);

	Employee updateEmployee(Employee employee);

	Employee findOneEmpById(Integer id);

	
}
