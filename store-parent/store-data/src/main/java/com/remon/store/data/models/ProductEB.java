package com.remon.store.data.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;

import com.remon.store.data.audit.AbstractAuditEntity;

@Entity
@Table(name = "PRODUCT")
public class ProductEB extends AbstractAuditEntity<Long>{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCT_ID_SEQ", sequenceName = "PRODUCT_ID_SEQ")
	@GeneratedValue(generator = "PRODUCT_ID_SEQ", strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Lob
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	@Column(name = "PRICE", nullable = false)
	private Double price;
	
	@Filter(name = "SHOPPING_MONTH_FILTER")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "product")
	private List<ShoppingEB> shoppings;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<ShoppingEB> getShoppings() {
		if(shoppings == null) {
			shoppings = new ArrayList<ShoppingEB>();
		}
		return shoppings;
	}

	public void setShoppings(List<ShoppingEB> shoppings) {
		this.shoppings = shoppings;
	}

	@Override
	public Long PK() {
		return getId();
	}

}
