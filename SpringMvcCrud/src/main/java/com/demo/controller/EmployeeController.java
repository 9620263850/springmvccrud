package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.demo.model.Employee;
import com.demo.service.EmployeeServices;

@Controller
public class EmployeeController {


	@Autowired
	EmployeeServices employeeServices;

	//EMPLOYEE FORM
	@GetMapping("/")
	public String  empForm()
	{
		return "AddEmployee";
	}

	//EMPLOYEE FROM
	@GetMapping("/addEmployee")
	public String  empFormm()
	{
		return "AddEmployee";
	}

	//SAVE EMPLOYEE
	@PostMapping("/insertEmployee")
	public String addEmployee(@ModelAttribute("insertEmployee") Employee emp)
	{
		employeeServices.addEmp(emp);
		return "redirect:/employeeReport";
	}

	//GET ALL EMPLOYEE
	@GetMapping("employeeReport")
	public String getAllEmployee(Model m)
	{
		m.addAttribute("employee",employeeServices.getAllEmp());
		m.addAttribute("title","Employee Report");
		return "EmployeeReport";
	}

	//GET EMPLOYEE BY ID
	@GetMapping("/editEmployee/{id}")
	public String getEmployeeById(@PathVariable(value="id") Long id,Model m)
	{
		Employee emp=employeeServices.getById(id);
		m.addAttribute("employee", emp);
		m.addAttribute("title","EMPLOYEE EDIT FORM");
		return "EditEmployee";
	}

	//UPDATE EMPLOYEE
	@PostMapping("/editEmployee/updateEmployee")
	public String updateEmployee(@ModelAttribute("updateEmployee") Employee emp)
	{
		employeeServices.updateEmp(emp);
		return "redirect:/employeeReport";
	}

	//DELETE EMPLOYEE BY ID
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
		employeeServices.deleteEmployee(id);
		return "redirect:/employeeReport";
	}
}
