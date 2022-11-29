package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.dao.EmployeeRepository;
import com.mvc.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("")
	   public String displayEmployee(Model model) {
	     List<Employee> employees = employeeRepo.findAll();
	      model.addAttribute("employeesList",employees);
	        return "list-employees";
	   }
	
	 @GetMapping("/new")
	public String displayForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
	  return "new-employee";
	}
	  @PostMapping("/save")
	  public String createProject(Employee employee,Model model) {
		 
		  employeeRepo.save(employee);
		  
		  return "redirect:/employees";
	   
	  }

}
