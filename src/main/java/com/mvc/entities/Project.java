package com.mvc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Project {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long projectId;
	private String name;
	private String stage;
	private String description;
	
	@ManyToMany (cascade = { CascadeType.DETACH,  CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY) 
	@JoinTable(name="project_employee", 
	               joinColumns= @JoinColumn(name="project_id"),
	               inverseJoinColumns=@JoinColumn(name="employee_id")
	)
	private List<Employee> employee;
	public  Project() {
		
	}
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}
	
	
	public List<Employee> getEmployee() {
        return employee;
    }
    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
    public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
