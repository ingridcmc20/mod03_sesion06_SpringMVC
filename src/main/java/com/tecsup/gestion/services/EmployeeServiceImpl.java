package com.tecsup.gestion.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.controller.EmployeeController;
import com.tecsup.gestion.dao.EmployeeDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {

		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}

	@Override
	public List<Employee> findAll() throws DAOException, EmptyResultException {

		List<Employee> emps = employeeDAO.findAllEmployees();

		return emps;
	}

	@Override
	public void update(Employee emp) throws DAOException {

		employeeDAO.update(emp);
	}

	@Override
	public void delete(int id) throws DAOException {

		employeeDAO.delete(id);

	}

	@Override
	public void create(Employee emp) throws DAOException {

		employeeDAO.create(emp);

	}

}
