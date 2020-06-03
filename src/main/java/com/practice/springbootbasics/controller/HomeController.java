package com.practice.springbootbasics.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springbootbasics.beans.Employee;
import com.practice.springbootbasics.exception.UserNotFoundException;
import com.practice.springbootbasics.service.IEmployeeService;

@RestController
public class HomeController {

	@Autowired
	IEmployeeService employeeService;

	/*
	 * @RequestMapping("/") public String defaulpath() { return
	 * "Hello World welcome to basic spring boot application"; }
	 */
	@GetMapping("/employees")
	@Cacheable(value = "/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/emp/{id}")
	public Employee findEmployeeById(@PathVariable("id") Integer id) {

		Optional<Employee> emp = employeeService.findEmployeeById(id);
		if (emp == null) {
			throw new UserNotFoundException("id: " + id);
		}

		/*
		 * Resource<Employee> resource = new Resource<Employee>(emp.get());
		 * 
		 * ControllerLinkBuilder linkTo =
		 * linkTo(methodOn(this.getClass()).getAllEmployee());
		 * 
		 * resource.add(linkTo.withRel("all-users"));
		 * 
		 * return resource;
		 */
		return emp.get();

	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addemployee")
	public @ResponseBody Employee addEmployee(@Valid @RequestBody Employee emp) {

		return employeeService.addEmployee(emp);
	}

	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployeeById(@PathVariable("id") Integer id) {

		return employeeService.deleteEmployeeById(id);

	}

	@PutMapping("/updateemployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@GetMapping("/findbyename")
	public List<Employee> findbyname(@RequestParam("ename") String ename) {
		System.out.println("enmae:" + ename);
		return employeeService.findByName(ename);

	}

	@GetMapping("/employee/{id}")
	public Employee findOneEmpById(@PathVariable("id") Integer id) {

		Employee emp = employeeService.findOneEmpById(id);
		if (emp == null) {
			throw new UserNotFoundException("id: " + id);
		}

		// Resource resource =new Resource(emp, uri)

		/*
		 * Resource<Employee> resource=new Resource<Employee>(emp); //constructor of
		 * Resource class //add link to retrieve all the users ControllerLinkBuilder
		 * linkTo=linkTo(methodOn(this.getClass()).retriveAllUsers());
		 * resource.add(linkTo.withRel("all-users")); return resource;
		 */

		return emp;
	}

}
