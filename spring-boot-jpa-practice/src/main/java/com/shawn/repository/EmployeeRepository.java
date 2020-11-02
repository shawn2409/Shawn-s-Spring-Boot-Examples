package com.shawn.repository;

import org.springframework.data.repository.CrudRepository;

import com.shawn.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String > {

}
