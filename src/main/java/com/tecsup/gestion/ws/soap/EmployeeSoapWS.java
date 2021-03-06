package com.tecsup.gestion.ws.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;
import com.tecsup.gestion.services.EmployeeService;
import com.tecsup.gestion.ws.soap.schema.EmployeeXSD;
import com.tecsup.gestion.ws.soap.schema.GetEmployeeRequest;
import com.tecsup.gestion.ws.soap.schema.GetEmployeeResponse;

@Endpoint
public class EmployeeSoapWS {
	private static final String NAMESPACE_URI = "http://www.tecsup.gestion/EmployeeSchema";
  
	@Autowired
	private EmployeeService employeeService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();

		Employee emp = null;
		try {
			emp = employeeService.find(request.getEmployeeId());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EmployeeXSD empXSD = new EmployeeXSD();
		
		if( emp != null) {
			empXSD.setEmployeeId(emp.getEmployeeId());
			empXSD.setFirstname(emp.getFirstname());
			empXSD.setLastname(emp.getLastname());
			empXSD.setSalary(emp.getSalary());
		}
		
		response.setEmployeeXSD(empXSD);

		return response;
	}

	
}
