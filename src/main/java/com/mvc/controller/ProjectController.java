package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.dao.EmployeeRepository;
import com.mvc.dao.ProjectRepository;
import com.mvc.entities.Employee;
import com.mvc.entities.Project;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
  @Autowired	
  ProjectRepository proRepo;
  @Autowired
  EmployeeRepository emRepo;
  @GetMapping("/new")
  public String displayProjectForm(Model model) {
        List<Employee> employees =emRepo.findAll();
		Project aProject = new Project();
		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aProject);
	return "new-project";
	  
  }
  @PostMapping("/save")
  public String createProject(Project project,Model model ) {
	 
	  proRepo.save(project);
	 
	   return "redirect:/projects";
   
  }
  @GetMapping("")
   public String displayHome(Model model) {
	 List<Project> projects = proRepo.findAll();
	  model.addAttribute("projects",projects);
		return "list-projects";
   }
  }

