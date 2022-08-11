package com.biricik.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.biricik.springboot.cruddemo.entity.Employee;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
