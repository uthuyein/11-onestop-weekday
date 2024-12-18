package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.OneToMany;
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
@Table(name = "category_tbl")
//@EntityListeners(TimesListener.class)
public class Category implements EnableTimesListener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false,unique = true)
	private  String name;
	
	@Embedded
	private Times times;
	
	@ColumnDefault("1")
	@Column(nullable = false,columnDefinition = "tinyint(1)")
	private  Boolean isActivated = true;
	
	@OneToMany(mappedBy = "category",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},orphanRemoval = true)
	private List<Product> products ;
	
	{
		products = new ArrayList<Product>();  
	}
	
	public void removeProduct(int index) {
		products.remove(index);
	}
	public void addProduct(Product p) {
		p.setCategory(this);
		products.add(p);
	}
	
	
}





