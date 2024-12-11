package com.jdc.mkt.entity;

import jakarta.persistence.AttributeConverter;

public class StringConverter implements AttributeConverter<String, Integer>{

	@Override
	public Integer convertToDatabaseColumn(String str) {
		if(null != str && !str.isEmpty()) {
			return Integer.parseInt(str);
		}
		return 0;
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		if(null != dbData) {
			return String.valueOf(dbData);
		}
		return null;
	}

}
