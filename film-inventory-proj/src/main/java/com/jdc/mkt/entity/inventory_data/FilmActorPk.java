package com.jdc.mkt.entity.inventory_data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class FilmActorPk implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "actor_id")
	private int actorId;
	
	@Column(name = "film_id")
	private int filmId;
}
