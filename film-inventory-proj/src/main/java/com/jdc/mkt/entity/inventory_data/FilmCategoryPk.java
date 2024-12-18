package com.jdc.mkt.entity.inventory_data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class FilmCategoryPk implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "film_id")
	private int filmId;
	
	@Column(name = "category_id")
	private int categoryId;
}
