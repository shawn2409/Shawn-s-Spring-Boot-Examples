package com.shawn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawn.model.Employee;
import com.shawn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllUsers() {
		List<Employee> emplList = new ArrayList<Employee>();

		employeeRepository.findAll().forEach(emplList::add);

		return emplList;
	}

	public void addUser(Employee employee) {
		employeeRepository.save(employee);
	}

}
