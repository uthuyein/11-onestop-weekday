package com.jdc.mkt.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static final String DOB = "dob";
	public static final String NAME = "name";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String DEPARTMENT = "department";

	
	/**
	 * @see com.jdc.mkt.entity.Employee#dob
	 **/
	public static volatile SingularAttribute<Employee, LocalDate> dob;
	
	/**
	 * @see com.jdc.mkt.entity.Employee#name
	 **/
	public static volatile SingularAttribute<Employee, String> name;
	
	/**
	 * @see com.jdc.mkt.entity.Employee#active
	 **/
	public static volatile SingularAttribute<Employee, Boolean> active;
	
	/**
	 * @see com.jdc.mkt.entity.Employee#id
	 **/
	public static volatile SingularAttribute<Employee, Integer> id;
	
	/**
	 * @see com.jdc.mkt.entity.Employee#department
	 **/
	public static volatile SingularAttribute<Employee, Department> department;
	
	/**
	 * @see com.jdc.mkt.entity.Employee
	 **/
	public static volatile EntityType<Employee> class_;

}

