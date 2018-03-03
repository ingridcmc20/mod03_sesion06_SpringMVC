package com.tecsup.gestion.dao;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.exception.LoginException;
import com.tecsup.gestion.model.Employee;

public interface EmployeeDAO {

	Employee validate(String login, String clave) throws LoginException, DAOException;

	List<Employee> findAllEmployees() throws DAOException, EmptyResultException;

	Employee findEmployee(int id) throws DAOException, EmptyResultException;

	void create(Employee emp) throws DAOException;

	void delete(int id) throws DAOException;

	void update(Employee emp) throws DAOException;

	Employee findByUsername(String username) throws DAOException, EmptyResultException;

}
