package com.shawn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shawn.model.Employee;
import com.shawn.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Employee> getAllemplyee() {
		return employeeService.getAllUsers();

	}

	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	public void addUser(@RequestBody Employee employee) {
		employeeService.addUser(employee);
	}

}
