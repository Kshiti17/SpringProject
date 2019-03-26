package com.firstProject.demoProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstProject.demoProject.model.Employee;
import com.firstProject.demoProject.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee empdata) {
		return empService.createEmployee(empdata);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllData(){
		return empService.getAllEmployees();
		
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable(value="id") Long id) {
		return empService.getEmpById(id);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id") Long id) {
		empService.deleteEmployee(id);
		return "Data Deleted Succesfully";
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable(value="id") Long id, @RequestBody Employee emp) {
		return empService.updateEmployee(id, emp);
	}
	

}
