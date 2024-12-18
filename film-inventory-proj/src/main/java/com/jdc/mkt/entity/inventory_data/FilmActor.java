package com.jdc.mkt.entity.inventory_data;

import com.jdc.mkt.entity.listeners.EnableTimesListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "film_actor_tbl")
public class FilmActor implements EnableTimesListener {

	@EmbeddedId
	private FilmActorPk id;
	
	@Embedded
	private Times times;
	
	@MapsId("filmId")
	@ManyToOne
	private Film film;
	
	@MapsId("actorId")
	@ManyToOne
	private Actor actor;
}
