package com.qsp.EmployeeRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qsp.EmployeeClass.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//fetchbyname
	public List<Employee> findByName(String name);
	
	
	//fetchby email and pass 
	public Employee findByEmailAndPassword(String name,String password);
}
