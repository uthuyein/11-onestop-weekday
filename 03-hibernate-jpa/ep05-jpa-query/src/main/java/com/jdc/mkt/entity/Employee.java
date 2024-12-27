package com.jdc.mkt.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_tbl")
@NamedQuery(
		name = "findCountByDepartmentName",
		query = "select count(e) from Employee e where e.department.name = :department")

@NamedNativeQuery(name = "findCountByDepartmentNameSql",
				query = """
						select count(*) from employee_tbl e
						join department_tbl d on e.department_id = d.id 
						where d.name = ?
						""" ,
				resultClass = Long.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	@Column(nullable = false)
	private LocalDate dob;
	
	@ColumnDefault("1")
	private boolean active;
	
	@ManyToOne
	private Department department;
	
	@Override
	public String toString() {
		return name;
	}
}
