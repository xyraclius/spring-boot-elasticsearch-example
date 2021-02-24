package com.springboot.elasticsearch.controller;

import java.util.List;

import com.springboot.elasticsearch.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.elasticsearch.model.Employee;


@RestController
@RequestMapping(value= "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService eserv;

	@PostMapping(value= "/save")
	public String saveEmployee(@RequestBody List<Employee> employeesList) {
		eserv.saveEmployee(employeesList);
		return "Records saved in the db.";
	}

	@GetMapping(value= "/get")
	public Iterable<Employee> getAllEmployees() {
		return eserv.findAllEmployees();
	}

	@GetMapping(value= "/find/{employee-designation}")
	public Iterable<Employee> getByDesignation(@PathVariable(name= "employee-designation") String designation) {
		return eserv.findByDesignation(designation);
	}
}
