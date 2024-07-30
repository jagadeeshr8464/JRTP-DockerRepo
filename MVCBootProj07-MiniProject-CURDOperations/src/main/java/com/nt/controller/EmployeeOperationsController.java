package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entitys.Employee;
import com.nt.service.IEmployeeService;

@Controller("empController")
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeService empService;
	
	@GetMapping("/")
	public String showHomePage()
	{
		System.out.println("EmployeeOperationsController.showHomePage()");
		return"welcome";
	}
	
	@GetMapping("/report")
	public String showAllEmp(Map<String,Object> map)
	{
		System.out.println("EmployeeOperationsController.showAllEmp()");
		List<Employee> empList=empService.getAllEmployee();
		map.put("eList", empList);
		return"showEmpList";
	}
	
	
	@GetMapping("/register")
	public String addEmployeeFormPage(@ModelAttribute("emp")Employee em)
	{
		System.out.println("EmployeeOperationsController.addEmployeeFormPage()");
		
		return "show_formPage";
	}
	
	/*
	 * @PostMapping("/register")
	 *  public String saveEmp(Map<String, Object>map,@ModelAttribute("emp")Employee e)
	 *   { 
	 *   String msg=empService.registerEmp(e);
	 * map.put("resultMsg", msg); 
	 * return"redirect:report"; 
	 * }
	 */
	/*
	 * @PostMapping("/register") public String saveEmp(HttpSession
	 * sesson,@ModelAttribute("emp")Employee e) { String
	 * msg=empService.registerEmp(e); sesson.setAttribute("resultMsg", msg);
	 * return"redirect:report";
	 *  } */
	
	//Best way to display result msg for source handler method to destination handler method
	  @PostMapping("/register") 
	  public String saveEmp(RedirectAttributes attrs,@ModelAttribute("emp")Employee e) 
	  {
		  System.out.println("EmployeeOperationsController.saveEmp()");
	   String msg=empService.registerEmp(e);
	    attrs.addFlashAttribute("resultMsg", msg);
	  return"redirect:report"; 
	  }
	 
	  @GetMapping("/edit")
	  public String showEditFormPage(@ModelAttribute("emp")Employee emp,@RequestParam(required = true)Integer no1)
	  {
		  System.out.println("EmployeeOperationsController.showEditFormPage()");
		 Employee employ= empService.serchEmpById(no1);
		 //copy recived employ obj date to model class
		 BeanUtils.copyProperties(employ,emp);//copies e obj data to employ  obj lick(employ.setEmpNo(e.getEmpNo());)
//		 employ.setEmpNo(emp.getEmpNo());
//		 employ.setEmpName(emp.getEmpName());
//		 employ.setJob(emp.getJob());
//		 employ.setSal(emp.getSal());
//		 employ.setDeptNo(emp.getDeptNo());
		 
		 //retun LVN
		 return "edit_employeeForm";
	  }
	  
	  @PostMapping("/edit")
	  public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee em)
	  {
		  String msg=empService.modifyEmployeeDetails(em);
		  attrs.addFlashAttribute("resultMsg", msg);
		  return "redirect:report";
	  }
	  
	  @GetMapping("/delete")
	  public String deletionOperation(RedirectAttributes attrs,@RequestParam("no2")Integer no2)
	  {
		  String msg=empService.deleteEmployee(no2);
		  attrs.addFlashAttribute("resultMsg", msg);
		  return "redirect:report";
		  
	  }
}
