package com.remon.store.data.audit;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class AuditEntity {

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	private Long createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	private Long updatedBy;
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
