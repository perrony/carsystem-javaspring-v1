package br.eti.scheffer.core.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Getter
@Setter
@Embeddable
public class AbstractyEntityCreatedUpdated {
	
	
	@Column(name = "created_at", nullable=false)
	public Date createdAt;
	
	@Column(name = "updated_at", nullable=false)
	public Date updatedAt;
	
	
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		createdAt = atual;
		updatedAt = atual;
	}

	public AbstractyEntityCreatedUpdated() {
		super();
		
	}
	

	
}
