package com.hibenate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FeeReceipt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "performance_id")
    private Student student;
	
	public String getName() {
		return name;
	}

	public FeeReceipt(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
}
