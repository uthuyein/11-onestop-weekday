package com.jdc.mkt.entity;

import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("stu")
public class Student extends Account{

	@ElementCollection
	@CollectionTable(name = "exam_marks_tbl",joinColumns = {
			@JoinColumn(name = "id")
	})
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "subject")
	private Map<Subject, Integer> examMarks;
	
	
	@Convert(converter = StringConverter.class)
	private String data;
	
	public enum Subject{
		MATHS,ENG,PHYSICS
	}
}
