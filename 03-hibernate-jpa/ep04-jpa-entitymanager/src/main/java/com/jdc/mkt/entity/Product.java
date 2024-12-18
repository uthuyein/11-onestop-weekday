package com.jdc.mkt.entity;

import org.hibernate.annotations.ColumnDefault;

import com.jdc.mkt.listeners.EnableTimesListener;
import com.jdc.mkt.listeners.Times;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "product_tbl")
//@EntityListeners(TimesListener.class)
//@ExcludeDefaultListeners
public class Product implements EnableTimesListener {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NonNull
	@Column(nullable = false, length = 45)
	private String name;

	@NonNull
	@Column(nullable = false)
	private Integer price;

	@Embedded
	private Times times;

	@ColumnDefault("1")
	@Column(nullable = false, columnDefinition = "tinyint(1) ")
	private boolean isActivated = true;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Category category;
}
