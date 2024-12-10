package com.jdc.mkt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OrderBy;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "collection_data_tbl")
public class CollectionData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dataId")
	private int id;
	@Column(nullable = false,unique = true)
	private int name;
	
	@ElementCollection
	@CollectionTable(name = "set_tbl",joinColumns = {
			@JoinColumn(name = "setId",referencedColumnName = "dataId")
	})
	@Column(name = "set_value")
	private Set<String> sets;
	
	@ElementCollection
	@CollectionTable(name = "list_tbl",joinColumns = {
			@JoinColumn(name = "listId",referencedColumnName = "dataId")
	})
	@OrderBy("set_value desc")
	private List<String> listValue;
	
	
	@ElementCollection
	@CollectionTable(name = "map_tbl",joinColumns = {
			@JoinColumn(name = "mapId")
	})
	@Column(name = "map_value")
	@MapKeyColumn(name = "map_key")
	@MapKeyEnumerated(EnumType.STRING)
	@OrderColumn(name = "map_key desc")
	private Map<MapKeyType, String> mapValue;
	
	@ElementCollection
	private List<Account>  listTypes;
	
	public enum MapKeyType{
		KEYONE,KEYTWO,KEYTHREE
	}
	
}
