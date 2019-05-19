package com.remon.store.data.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;

import com.remon.store.data.audit.AbstractAuditEntity;

@Entity
@Table(name = "SHOPPING")
@FilterDefs({
	@FilterDef(	name = "SHOPPING_MONTH_FILTER", 
				defaultCondition = "MONTH(createdOn) = :month AND YEAR(createdOn) = :year", 
				parameters = {
							@ParamDef(type = "java.lang.Integer", name = "month"),
							@ParamDef(type = "java.lang.Integer", name = "year")
						})
})
public class ShoppingEB extends AbstractAuditEntity<Long>{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SHOPPING_ID_SEQ", sequenceName = "SHOPPING_ID_SEQ")
	@GeneratedValue(generator = "SHOPPING_ID_SEQ", strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private ProductEB product;
	
	@Column(name = "QUANTITY", nullable = false)
	private Double quantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProductEB getProduct() {
		return product;
	}
	public void setProduct(ProductEB product) {
		this.product = product;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Override
	public Long PK() {
		return getId();
	}

}
