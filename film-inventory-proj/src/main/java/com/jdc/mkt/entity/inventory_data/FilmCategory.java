package com.jdc.mkt.entity.inventory_data;

import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FilmCategory {

	@EmbeddedId
	private FilmCategoryPk id;
	
	@Embedded
	private Times times;
	
	@MapsId("categoryId")
	@ManyToOne
	private Category category;
	
	@MapsId("filmId")
	@ManyToOne
	private Film film;
}
