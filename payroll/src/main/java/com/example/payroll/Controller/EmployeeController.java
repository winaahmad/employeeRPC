package com.example.payroll.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payroll.Exception.EmployeeNotFoundException;
import com.example.payroll.Model.*;
import com.example.payroll.Repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private final EmployeeRepository repository;
	
	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;   
	}
	
	// get all employees
	@GetMapping("/employee")
	List<EmployeeEntity> getEmployees() {
		return repository.findAll();
	}
	
	// create employee
	@PostMapping("/employee")
	EmployeeEntity createEmployee(@RequestBody EmployeeEntity newEmployee) {
		return repository.save(newEmployee);
	}
	
	// get employee by id
	@GetMapping("/employee/{id}")
	EmployeeEntity getEmployee(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}
	
	// update an employee
	@PutMapping("/employee/{id}")
	EmployeeEntity updateEmployee(@RequestBody EmployeeEntity newEmployee, @PathVariable Long id) {
		return repository.findById(id)
				.map(employee -> {
					employee.setfirstName(newEmployee.getfirstName());
					employee.setlastName(newEmployee.getlastName());
					employee.setRole(newEmployee.getRole());
					return repository.save(employee);
				})
				.orElseGet(() ->{
					newEmployee.setId(id);
					return repository.save(newEmployee);
				});
	}
	
	// delete an employee
	@DeleteMapping("/employee/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
