package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;
@Component
@Service
public class EmployeeServices {

	@Autowired
	EmployeeDao employeeDao;

	//ADD EMPLOYEE
	public void addEmp(Employee emp)
	{
		employeeDao.addEmployee(emp);
	}

	//GET ALL EMPLOYEE
	public List<Employee> getAllEmp()
	{
		return employeeDao.getAllEmp();
	}

	//GET EMPLOYEE BY ID	
	public Employee getById(Long id)
	{
		return employeeDao.getEmpById(id);
	}

	//UPDATE EMPLOYEE	
	public void updateEmp(Employee emp)
	{
		employeeDao.updateEmp(emp);
	}

	//DELETE EMPLOYEE
	public void deleteEmployee(Long id)
	{
		employeeDao.deleteEmp(id);
	}

}