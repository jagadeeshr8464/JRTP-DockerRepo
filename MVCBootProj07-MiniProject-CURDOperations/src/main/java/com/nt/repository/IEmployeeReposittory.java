package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entitys.Employee;

public interface IEmployeeReposittory extends JpaRepository<Employee, Integer>{

}
