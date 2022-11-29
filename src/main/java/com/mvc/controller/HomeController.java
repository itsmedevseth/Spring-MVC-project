package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mvc.dao.EmployeeRepository;
import com.mvc.dao.ProjectRepository;
import com.mvc.dto.EmployeeProject;
import com.mvc.entities.Employee;
import com.mvc.entities.Project;



@Controller
public class HomeController {
	
	@Autowired
	
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	@GetMapping("/")
   public String displayHome(Model model) {
	 List<Project>  projects = proRepo.findAll();
	  model.addAttribute("projectList",projects);
	  
	  List<EmployeeProject>  employeesProjectCnt = empRepo.employeeProjects();
      model.addAttribute("employeesListProjectCnt",employeesProjectCnt);
		return "home";
   }

} 
