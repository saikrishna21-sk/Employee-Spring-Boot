package com.vcube.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.employees.Respository.EmployeeRepository;
import com.vcube.employees.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepo;

	@PostMapping("postEmployeeDetails/")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeRepo.save(emp);
	}

	@GetMapping("getemployeeDetails/")
	public List<Employee> getAllEmployeesDetails() {
		return employeeRepo.findAll();
	}

	@GetMapping("getemployeeDetail/{id}")
	public Employee getEmployeeDetailById(@PathVariable Integer id) {
		return employeeRepo.findById(id).orElseThrow();
	}

	@GetMapping("getEmployeeDetails/{email}")
	public Employee getByEmail(@PathVariable String email) {
		return employeeRepo.findByEmail(email).orElseThrow();
	}

	@GetMapping("getEmployeeDetails/department/{department}")
	public List<Employee> getbyDepartment(@PathVariable String department) {
		return employeeRepo.findByDepartment(department);
	}

	@PutMapping("updateempDetails/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable Integer id) {
		Employee e = employeeRepo.findById(id).orElseThrow();
		e.setName(emp.getName());
		e.setEmail(emp.getEmail());
		e.setDepartment(emp.getDepartment());
		e.setSalary(emp.getSalary());

		return employeeRepo.save(e);
	}

	@PatchMapping("updateEmpDetailsBySalary/salary/{id}")
	public Employee updateSalary(@PathVariable Integer id, @RequestBody Employee emp) {
		Employee e = employeeRepo.findById(id).orElseThrow();
		e.setSalary(emp.getSalary());
		return employeeRepo.save(e);
	}

	@DeleteMapping("deletingEmployee/{id}")
	public String deleteEmp(@PathVariable Integer id) {
		employeeRepo.deleteById(id);
		return "employee deleted";
	}
}
