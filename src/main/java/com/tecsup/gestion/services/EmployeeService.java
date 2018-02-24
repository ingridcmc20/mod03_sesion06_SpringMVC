package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;

public interface EmployeeService {
	
	Employee find(int employee_id) throws DAOException, EmptyResultException;

	List<Employee> findAll() 
			throws DAOException, EmptyResultException;

	void update(Employee emp) throws DAOException;

	void delete(int id) throws DAOException;

	void create(Employee emp) throws DAOException;

}
