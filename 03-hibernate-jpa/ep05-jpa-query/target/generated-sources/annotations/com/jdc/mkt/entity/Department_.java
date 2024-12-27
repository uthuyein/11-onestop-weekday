package com.jdc.mkt.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Department.class)
public abstract class Department_ {

	public static final String NAME = "name";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String EMPLOYEES = "employees";

	
	/**
	 * @see com.jdc.mkt.entity.Department#name
	 **/
	public static volatile SingularAttribute<Department, String> name;
	
	/**
	 * @see com.jdc.mkt.entity.Department#active
	 **/
	public static volatile SingularAttribute<Department, Boolean> active;
	
	/**
	 * @see com.jdc.mkt.entity.Department#id
	 **/
	public static volatile SingularAttribute<Department, Integer> id;
	
	/**
	 * @see com.jdc.mkt.entity.Department#employees
	 **/
	public static volatile ListAttribute<Department, Employee> employees;
	
	/**
	 * @see com.jdc.mkt.entity.Department
	 **/
	public static volatile EntityType<Department> class_;

}

