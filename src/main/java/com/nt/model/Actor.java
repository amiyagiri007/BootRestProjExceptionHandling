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

}
