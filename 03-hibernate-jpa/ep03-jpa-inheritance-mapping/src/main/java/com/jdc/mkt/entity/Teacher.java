package com.jdc.mkt.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("tea")
public class Teacher extends Account {

	@ElementCollection
	@CollectionTable(name = "course_tbl"
	,joinColumns = {
			@JoinColumn(name = "id")
	})
	@Column(name = "course_name")
	private List<String> courses;
	
	
}
