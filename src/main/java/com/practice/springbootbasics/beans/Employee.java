package com.practice.springbootbasics.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empId;
	
	@Size(min=5, message="Name should have at least 5 characters")
	private String ename;
	
	public Employee() {
		
	}
	
	
	public Employee(Integer empId, String ename) {
		this.empId = empId;
		this.ename = ename;
	}


	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + "]";
	}
	

}
