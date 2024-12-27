package com.jdc.mkt.entity;

import java.util.List;

import jakarta.persistence.metamodel.SingularAttribute;

public class Department_ {

//	public static final String ID = "id";
//	public static final String NAME = "name";
//	public static final String EMPLOYEES = "employees";
//	public static final String ACTIVE = "active";
	
	public static volatile SingularAttribute<Department, Integer> id;
	public static volatile SingularAttribute<Department, String> name;
	public static volatile SingularAttribute<Department, List<Employee>> employees;
	public static volatile SingularAttribute<Department, Boolean> active;
}
