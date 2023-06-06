package com.qsp.EmployeeController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.EmployeeClass.Employee;
import com.qsp.EmployeeRepository.EmployeeRepository;

@RestController
public class EmployeeController
{
	@Autowired
	EmployeeRepository er;
	
	@PostMapping("/saveemployee")
	public String saveemployee(@RequestBody Employee e)//JSOn to JAva
	{
		er.save(e);
		return "Employee Data Saved";
		
	}
	//fetch data by id
	@GetMapping("/fetchdatabyid") 
	public Employee fetchdatabyid(@RequestParam int id)
	{
		Optional<Employee> o=er.findById(id);
		Employee employees=o.get();
		return employees;
		
	}
	
	//fetch by name
	@GetMapping("/fetchbyname") //localhost:65382 /fetchbyname?name=venky
	public List<Employee> fetchbyname(@RequestParam String name)
	{
		List<Employee> emplo=er.findByName(name);
		return emplo;
	}
	//fetch by email and pass
	@GetMapping("fetchbyemailandpass")
									//private email and pass in JSON
	public Employee fetchbyemailandpassord(@RequestBody Employee em)
	{
		return er.findByEmailAndPassword(em.getEmail(), em.getPassword());
	}
	
	//fetch all data
	@GetMapping("/fetchallemployee")
	public List<Employee> fetchallemployee()
	{
		return er.findAll();
	}
	
	
	//update
	@PutMapping("/updateemployee")
	public String updateemployee(@RequestBody Employee em )
	{
		er.save(em);
		return "Data Updated Successfully";
	}
	
	//delete
	@DeleteMapping("/deleteemployeebyid")
	public String deletestring(@RequestParam int id)
	{
		er.deleteById(id);
		return "Data Deleted Successfully";
	}
	
	}


