package com.jdc.mkt.entity;

import java.time.LocalDate;

import jakarta.persistence.metamodel.SingularAttribute;

public class Employee_ {

//	public static final String ID = "id";
//	public static final String NAME = "name";
//	public static final String DOB = "dob";
//	public static final String DEPARTMENT = "department";
//	public static final String ACTIVE = "active";
//	
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, LocalDate> dob;
	public static volatile SingularAttribute<Employee, Department> department;
	public static volatile SingularAttribute<Employee, Boolean> active;
}
