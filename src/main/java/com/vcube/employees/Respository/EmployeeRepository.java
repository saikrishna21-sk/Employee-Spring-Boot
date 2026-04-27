package com.vcube.employees.Respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.employees.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	Optional<Employee> findByEmail(String email);
	
	List<Employee> findByDepartment(String Department);
	
	List<Employee> findBySalaryGreaterThan(Double salary);

}
