package com.biricik.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biricik.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
