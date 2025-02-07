package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Actor {

	@Id
	@GeneratedValue
	private Integer actorId;
	@Column(name = "actor_name", length = 20)
	private String actorname;
	@Column(length = 20)
	private String category;
	private Long mobno;
	public Actor(Integer actorId, String actorname, String category, Long mobno) {
		super();
		this.actorId = actorId;
		this.actorname = actorname;
		this.category = category;
		this.mobno = mobno;
	}
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public String getActorname() {
		return actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getMobno() {
		return mobno;
	}

	public void setMobno(Long mobno) {
		this.mobno = mobno;
	}
	

}
