package com.tecsup.gestion.ws.restful;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;
import com.tecsup.gestion.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeRESTfulWS {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeRESTfulWS.class);

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/wsrf/emp")
	public ResponseEntity<?> list() {

		List<Employee> list = null;

		try {
			list = employeeService.findAll();
		} catch (DAOException | EmptyResultException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<MessageRESTful>(new MessageRESTful(e.getMessage()), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/wsrf/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {
		Employee emp = null;

		try {
			emp = employeeService.find(id);
			logger.info(emp.toString());
		} catch (DAOException | EmptyResultException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<MessageRESTful>(new MessageRESTful(e.getMessage()), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	/**
	 * 
	 * @param emp
	 * @param ucBuilder
	 * @return
	 */
	@PostMapping("/wsrf/emp")
	public ResponseEntity<?> createUser(@RequestBody Employee emp, UriComponentsBuilder ucBuilder) {

		logger.info("Creating User " + emp);

		try {

			employeeService.create(emp);

			emp = employeeService.findByUsername(emp.getUsername());

		} catch (DAOException | EmptyResultException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<MessageRESTful>(new MessageRESTful(e.getMessage()), HttpStatus.CONFLICT);

		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/wsrf/emp/{id}").buildAndExpand(emp.getEmployeeId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param id
	 * @param emp
	 * @return
	 */
	@PutMapping("/wsrf/emp/{id}")
	public ResponseEntity<?> updateEmp(@PathVariable("id") int id, @RequestBody Employee emp) {

		logger.info("Updating Employee " + id);

		Employee currentEmp = null;
		try {
			currentEmp = employeeService.find(id);

			// currentEmp.setUsername(emp.getUsername());
			currentEmp.setFirstname(emp.getFirstname());
			currentEmp.setLastname(emp.getLastname());
			currentEmp.setSalary(emp.getSalary());

			employeeService.update(currentEmp);

			currentEmp = employeeService.find(id);

		} catch (DAOException | EmptyResultException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<MessageRESTful>(new MessageRESTful(e.getMessage()), HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Employee>(currentEmp, HttpStatus.OK);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/wsrf/emp/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable("id") int id) {
		logger.info("Fetching & Deleting Employee with id " + id);

		Employee emp;
		try {
			emp = employeeService.find(id);

			employeeService.delete(emp.getEmployeeId());

		} catch (DAOException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<MessageRESTful>(new MessageRESTful(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (EmptyResultException e) {
			logger.error(e.getMessage());
			String msgError = "Unable to delete. Employee with id " + id + " not found";
			logger.info(msgError);
			return new ResponseEntity<MessageRESTful>(new MessageRESTful(msgError), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/**
	 * 
	 * @author jgomezm
	 *
	 */
	private class MessageRESTful {

		String message;

		public MessageRESTful(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

}
