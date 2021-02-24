package com.springboot.elasticsearch.service.impl;

import java.util.List;

import com.springboot.elasticsearch.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.elasticsearch.model.Employee;
import com.springboot.elasticsearch.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// The dao repository will use the Elastic-Search-Repository to perform the database operations.
	@Autowired
	private EmployeeRepository edao;

	/* (non-Javadoc)
	 * @see com.springboot.elasticsearch.service.EmployeeService#saveEmployee(java.util.List)
	 */
	@Override
	public void saveEmployee(List<Employee> employees) {
		edao.saveAll(employees);
	}

	/* (non-Javadoc)
	 * @see com.springboot.elasticsearch.service.EmployeeService#findAllEmployees()
	 */
	@Override
	public Iterable<Employee> findAllEmployees() {
		return edao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.springboot.elasticsearch.service.EmployeeService#findByDesignation(java.lang.String)
	 */
	@Override
	public List<Employee> findByDesignation(String designation) {
		return edao.findByDesignation(designation);
	}
}
