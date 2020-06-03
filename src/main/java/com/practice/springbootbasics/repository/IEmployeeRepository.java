package com.practice.springbootbasics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.springbootbasics.beans.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByEname(String ename);

}
