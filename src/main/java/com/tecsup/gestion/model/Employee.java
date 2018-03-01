package com.tecsup.gestion.model;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

 
public class Employee extends Credential {

	int employeeId;

	@NotEmpty
	String firstname;
	
	@NotEmpty
	String lastname;
	
	@Range(min = 850, max = 4000)
	int salary;

	@NotEmpty
	String repassword;
	
	//@NotEmpty
	//@Email
	String email;
	

	int departmentId;

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * 
	 * @param login
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param salary
	 */
	public Employee(String login, String password, String firstname, String lastname, int salary) {
		super(login, password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeID) {
		this.employeeId = employeeID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [login=" + username + ", password=" + password + ", repassword=" + repassword + ", employeeId=" + employeeId + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", salary=" + salary + "]";
	}

}
