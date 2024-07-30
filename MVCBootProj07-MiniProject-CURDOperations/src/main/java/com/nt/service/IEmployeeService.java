package com.nt.service;

import java.util.List;

import com.nt.entitys.Employee;

public interface IEmployeeService {

	public List<Employee> getAllEmployee();
	public String registerEmp(Employee e);
	public Employee serchEmpById(Integer no);
	public String modifyEmployeeDetails(Employee emp);
	public String deleteEmployee(Integer no);
	
}
