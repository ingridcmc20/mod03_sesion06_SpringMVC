package com.tecsup.gestion.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.exception.LoginException;
import com.tecsup.gestion.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee validate(String login, String clave) throws LoginException, DAOException {
		// TODO Auto-generated method stub

		String query = "SELECT login, password, employee_id, first_name, last_name, salary, department_id  "
				+ " FROM EMPLOYEES WHERE login=? AND password=?";
	
		Object[] params = new Object[] { login, clave };
		
		try {
	
			Employee emp = 
					(Employee) jdbcTemplate.
						queryForObject(query, params, new EmployeeMapper());
			//
			return emp;
	
		} catch (EmptyResultDataAccessException e) {
			logger.info("Employee y/o clave incorrecto");
			throw new LoginException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}

		
	}

	@Override
	public List<Employee> findAllEmployees() throws DAOException, EmptyResultException {

		String query = "SELECT employee_id, login, password, first_name, last_name, salary, department_id FROM EMPLOYEES ";

		try {

			List<Employee> employees = jdbcTemplate.query(query, new EmployeeMapper());
			//
			return employees;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void create(Employee emp) throws DAOException {

		String query = "INSERT INTO EMPLOYEES (login, password, first_name, last_name, salary, department_id)  VALUES ( ?,?,?,?,?,? )";

		Object[] params = new Object[] { emp.getUsername(), emp.getPassword(), emp.getLastname(), emp.getFirstname(), emp.getSalary(), emp.getDepartmentId() };

		
		try {
			// create
			jdbcTemplate.update(query, params);

		} catch (Exception e) {
			//logger.error("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		

	}
	
	@Override
	public Employee findEmployee(int employee_id) throws DAOException, EmptyResultException {

		String query = "SELECT employee_id, login, password, first_name, last_name, salary, department_id "
				+ " FROM EMPLOYEES WHERE employee_id = ?";

		Object[] params = new Object[] { employee_id };

		try {

			Employee emp = (Employee) jdbcTemplate.queryForObject(query, params, new EmployeeMapper());
			//
			return emp;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public void update(Employee emp) throws DAOException {

		String query = "UPDATE EMPLOYEES SET password = ?, first_name =?, last_name = ?, salary = ? WHERE employee_id = ?";

		Object[] params = new Object[] { emp.getPassword(), emp.getLastname(), emp.getFirstname(), emp.getSalary(), emp.getEmployeeId() };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public void delete(int employee_id) throws DAOException {

		String query = "DELETE FROM  EMPLOYEES WHERE employee_id = ? ";

		Object[] params = new Object[] { employee_id };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	// private class Mapper
	private class EmployeeMapper implements RowMapper<Employee> {

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setUsername(rs.getString("login"));
			emp.setPassword(rs.getString("password"));
			emp.setFirstname(rs.getString("first_name"));
			emp.setLastname(rs.getString("last_name"));
			emp.setSalary(rs.getInt("salary"));
			return emp;
		}
	}

}
