package com.tecsup.gestion.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.model.Employee;
import com.tecsup.gestion.services.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	// Department Default
	private static final int DEPARTMENT_DEFAULT = 100;

	private static final int SALARY_MIN = 850;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ApplicationContext context;

	@GetMapping("/user/403")
	public ModelAndView accessDenied() {
		return new ModelAndView("/user/403");
	}
	
	@GetMapping("/user/menu")
	public ModelAndView menu() {
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	      String name = auth.getName(); //get logged in username 
//	      logger.info("Name : " + name);
		
		return new ModelAndView("/user/menu");
	}

	@GetMapping("/admin/emp/list")
	public ModelAndView list(@ModelAttribute("employee") Employee employee, ModelMap model) {

		model.addAttribute("employeeMngShow", "show");
		model.addAttribute("listEmployeeActive", "active");

		try {
			model.addAttribute("employees", employeeService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return new ModelAndView("admin/emp/list");
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// CREATION //
	//////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/admin/emp/createform")
	public ModelAndView createform(ModelMap model) {

		model.addAttribute("employeeMngShow", "show");
		model.addAttribute("createEmployeeActive", "active");

		Employee emp = new Employee();
		emp.setDepartmentId(DEPARTMENT_DEFAULT);
		emp.setSalary(SALARY_MIN);

		return new ModelAndView("admin/emp/createform", "employee", emp);

	}

	@PostMapping("/admin/emp/create")
	public ModelAndView create(@ModelAttribute("employee") @Valid Employee emp, BindingResult result, ModelMap model) {

		// String msg = context.getMessage("employee.salary.min", null, Locale.US);
		// logger.info("message = " + msg);

		logger.info("emp = " + emp);

		model.addAttribute("employeeMngShow", "show");
		model.addAttribute("createEmployeeActive", "active");

		ModelAndView modelAndView = null;

		if (result.hasErrors()) {

			printValidateForm(result);

			modelAndView = new ModelAndView("admin/emp/createform", "employee", emp);

		} else {

			if (emp.getPassword().equals(emp.getRepassword()))
				try {
					employeeService.create(emp);
					logger.info("new Employee login = " + emp.getUsername());
					modelAndView = new ModelAndView("redirect:/admin/emp/list");

				} catch (DAOException e) {
					logger.error(e.getMessage());
					model.addAttribute("message", e.getMessage());
					modelAndView = new ModelAndView("admin/emp/createform", "employee", emp);
				}
			else {
				model.addAttribute("message", "Password and Confirm Password are diferent ....!");
				modelAndView = new ModelAndView("admin/emp/createform", "employee", emp);
			}
		}
		//
		return modelAndView;
	}


	//////////////////////////////////////////////////////////////////////////////////////
	// SHOW EDIT FORM OR DELETE FORM//
	//////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/admin/emp/{action}/{employee_id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int employee_id, ModelMap model) {

		logger.info("action = " + action);

		model.addAttribute("employeeMngShow", "show");
		model.addAttribute("listEmployeeActive", "active");

		ModelAndView modelAndView = null;

		try {
			Employee emp = employeeService.find(employee_id);
			emp.setRepassword(emp.getPassword());
			logger.info(emp.toString());
			modelAndView = new ModelAndView("admin/emp/" + action, "employee", emp);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/emp/" + action, "employee", new Employee());
		}

		return modelAndView;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// UPDATE //
	//////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/admin/emp/update")
	public ModelAndView update(@ModelAttribute("employee") @Valid Employee emp, BindingResult result, ModelMap model) {

		logger.info("emp = " + emp);

		model.addAttribute("employeeMngShow", "show");
		model.addAttribute("listEmployeeActive", "active");

		ModelAndView modelAndView = null;

		if (result.hasErrors()) {
			printValidateForm(result);
			modelAndView = new ModelAndView("admin/emp/editform", "employee", emp);
		} else {
			if (emp.getPassword().equals(emp.getRepassword()))
				try {
					employeeService.update(emp);
					modelAndView = new ModelAndView("redirect:/admin/emp/list");

				} catch (Exception e) {

					model.addAttribute("message", e.getMessage());
					modelAndView = new ModelAndView("admin/emp/editform", "employee", emp);
				}
			else {
				model.addAttribute("message", "Password and Confirm Password are diferent ....!");
				modelAndView = new ModelAndView("admin/emp/editform", "employee", emp);
			}

		}

		return modelAndView;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// DELETE //
	//////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/admin/emp/delete")
	public ModelAndView delete(@ModelAttribute("employee") Employee emp,  ModelMap model) {

		logger.info("emp = " + emp);

		model.addAttribute("employeeMngShow", "show");
		model.addAttribute("listEmployeeActive", "active");

		ModelAndView modelAndView = null;

		try {
			employeeService.delete(emp.getEmployeeId());
			modelAndView = new ModelAndView("redirect:/admin/emp/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/emp/deleteform", "employee", emp);
		}
		
		return modelAndView;
	}
	
	private void printValidateForm(BindingResult result) {
		logger.info("result.getAllErrors();= " + result.getAllErrors());

//		for (ObjectError error : result.getAllErrors()) {
//			logger.info("error = " + error);
//			logger.info("error.getCode() = " + error.getCode());
//			logger.info(" error.getArguments() = " +  error.getArguments());
//			
//			String theMessage = context.getMessage(error.getCode(), error.getArguments(), Locale.US);
//			logger.info(error.getCode() + " = " + theMessage);
//		}
	}

}
