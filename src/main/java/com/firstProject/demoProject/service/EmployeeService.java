package com.firstProject.demoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstProject.demoProject.model.Employee;
import com.firstProject.demoProject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	//For Post API
	public Employee createEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	//For GetAll Api
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	//For GetEmloyeeById Api
	public Employee getEmpById(Long id) {
		return empRepo.findById(id).get();
	}
	
	//For Delete Api
	public void deleteEmployee(Long id) {
		Employee em = empRepo.findById(id).get();
		empRepo.delete(em);
	}
	
	//For Update Api
	public Employee updateEmployee(Long id,Employee emp) {
		Employee em = empRepo.findById(id).get();
		em.setName(emp.getName());
		em.setDesignation(emp.getDesignation());
		empRepo.save(em);
		return em;
	}

}
