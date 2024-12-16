package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false,unique = true)
	private  String name;
	
	@ColumnDefault("1")
	private  boolean isActivated;
	
	@OneToMany(mappedBy = "category",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
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





