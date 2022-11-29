package com.mvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.entities.Project;


public interface ProjectRepository extends CrudRepository<Project,Long> {
  
	@Override
	public List <Project> findAll();
}
