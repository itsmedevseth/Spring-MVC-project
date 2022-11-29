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
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	
	
	@ManyToMany (cascade = { CascadeType.DETACH,  CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
	            fetch = FetchType.LAZY) 
	@JoinTable(name="project_employee", 
    joinColumns= @JoinColumn(name="employee_id"),
    inverseJoinColumns=@JoinColumn(name="project_id")
	)
	
	private List<Project> theProject;
	
	
    public List<Project> getTheProject() {
        return theProject;
    }
    public void setTheProject(List<Project> theProject) {
        this.theProject = theProject;
    }
    public Employee() {}
	public Employee(long employeeId, String firstName, String lastName, String email) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}