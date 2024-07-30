package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entitys.Employee;
import com.nt.repository.IEmployeeReposittory;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeReposittory empRepo;
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=empRepo.findAll();
		list.sort((emp,emp1)->emp.getEmpNo()-emp1.getEmpNo());
		return list;
	}
	
	@Override
	public String registerEmp(Employee e) {
        
	        Integer empId=empRepo.save(e).getEmpNo();

		return "Employee Register with Id:"+empId;
	}

	@Override
	public Employee serchEmpById(Integer no) {
             
//		Optional<Employee> employee=empRepo.findById(no);
//		return employee.get();
		return empRepo.findById(no).orElseThrow(()->new IllegalArgumentException("Employee is not fount"));
		
	}

	@Override
	public String modifyEmployeeDetails(Employee emp) {
              
		Optional<Employee> em=empRepo.findById(emp.getEmpNo());
		if(em.isPresent())
		{
			empRepo.save(emp);
			return emp.getEmpNo()+"--->Employee details are Updated";
		}

		return emp.getEmpNo()+"--->Employee details are Not Updated";
	}

	@Override
	public String deleteEmployee(Integer no) {
      Optional<Employee>   opl  =empRepo.findById(no);
      if(opl.isPresent())
      {
    	  empRepo.deleteById(no);
    	  return  no+ "  Employee is Deleted";
      }
		return no+ " Employee is Not fount for Deletion";
	}
}
