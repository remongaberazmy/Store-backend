package com.remon.store.data.audit;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.OptimisticLock;

import com.remon.store.data.base.AbstractEntity;

@MappedSuperclass
public abstract class AbstractAuditEntity<ID extends Serializable> extends AbstractEntity<ID> {

	private static final long serialVersionUID = 1L;

	@Embedded
	@OptimisticLock(excluded = false)
	private AuditEntity audit;

	public AuditEntity getAudit() {
		return audit;
	}

	public void setAudit(AuditEntity audit) {
		this.audit = audit;
	}
	
}
